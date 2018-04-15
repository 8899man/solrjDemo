package cn.ruanwenjun.jd.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Controller;

import cn.ruanwenjun.jd.domain.Product;
import cn.ruanwenjun.jd.domain.QueryVo;

/**
 * @author ruanwenjun 
 *		   E-mail:861923274@qq.com
 * @date 2018年4月15日 上午10:59:14
*/
@Controller
public class ProductDao {
	
	//根据条件查询
	public List<Product> queryByQueryVo(QueryVo vo) throws SolrServerException {
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
		SolrQuery query = new SolrQuery();
		
		//查询关键字
		if(vo.getQueryString() !=null && !vo.getQueryString().trim().equals("")) {
			query.set("q", "product_keywords:"+vo.getQueryString().trim());
		}
		//设置查询大小
		query.setStart(0);
		query.setRows(16);
		//设置查询域
		query.set("fl", "id,product_price,product_name,product_picture");
		
		//设置查询条件
		if(vo.getCatalog_name() != null && !vo.getCatalog_name().equals("")) {
			query.set("fq", "product_catalog_name:"+vo.getCatalog_name());
		}
		if(vo.getPrice() != null && !vo.getPrice().equals("")) {
			String product_price = vo.getPrice();
			String[] split = product_price.split("-");
			query.set("fq", "product_price:[" + split[0] + " TO " + split[1] + "]");
		}
		//为1则表示降序
		if(!vo.getSort().equals("1")) {
			query.set("sort", "product_price asc");  //升序
		}else {
			query.set("sort", "product_price desc"); //降序
		}
		
		//开启高亮查询
		query.setHighlight(true);
		query.set("hl.fl", "product_name");
		query.setHighlightSimplePre("<span style='color:red '>");
		query.setHighlightSimplePost("</span>");
		
		QueryResponse response = solrServer.query(query);
		SolrDocumentList solrDocumentList = response.getResults();
		
		//高亮查询结果
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		
		List<Product> productList = new ArrayList<Product>();
		//查询总数
		long numFound = solrDocumentList.getNumFound();
		
		for (SolrDocument solrDocument : solrDocumentList) {
			String id = (String) solrDocument.getFieldValue("id");
			Float price = (Float) solrDocument.getFieldValue("product_price");
			String picture = (String) solrDocument.getFieldValue("product_picture");
			String name = (String) solrDocument.getFieldValue("product_name");
			//获得高亮的名字
			Map<String, List<String>> map = highlighting.get(id);
			List<String> list = map.get("product_name");
			if(list != null) {
				name = list.get(0);
			}
			
			Product product = new Product(id,price,name,picture);
			productList.add(product);
		}
		
		return productList;
	}
}

package cn.ruanwenjun.jd.service;

import java.util.List;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.ruanwenjun.jd.dao.ProductDao;
import cn.ruanwenjun.jd.domain.Product;
import cn.ruanwenjun.jd.domain.QueryVo;

/**
 * @author ruanwenjun 
 *		   E-mail:861923274@qq.com
 * @date 2018年4月15日 上午11:36:32
*/

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductDao productDao;
	
	//根据VO查询商品
	public List<Product> queryByQueryVo(QueryVo vo) {
		try {
			List<Product> productList = productDao.queryByQueryVo(vo);
			return productList;
		} catch (Exception e) {
			System.out.println("异常");
			return null;
		}
	}
}

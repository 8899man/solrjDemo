package cn.ruanwenjun.jd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.ruanwenjun.jd.domain.Product;
import cn.ruanwenjun.jd.domain.QueryVo;
import cn.ruanwenjun.jd.service.IProductService;

/**
 * @author ruanwenjun 
 *		   E-mail:861923274@qq.com
 * @date 2018年4月15日 上午10:43:14
*/
@Controller
public class IndexController {
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value="index.action")
	public String list(QueryVo vo,Model model) {
		
		//根据条件查询
		List<Product> productList = productService.queryByQueryVo(vo);
		
		model.addAttribute("productList", productList);
		model.addAttribute("queryString", vo.getQueryString());
		model.addAttribute("catalog_name", vo.getCatalog_name());
		model.addAttribute("price", vo.getPrice());
		model.addAttribute("sort", vo.getSort());
		
		return "product_list";
	}
}

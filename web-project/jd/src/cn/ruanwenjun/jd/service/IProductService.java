package cn.ruanwenjun.jd.service;

import java.util.List;
import cn.ruanwenjun.jd.domain.Product;
import cn.ruanwenjun.jd.domain.QueryVo;

/**
 * @author ruanwenjun 
 *		   E-mail:861923274@qq.com
 * @date 2018年4月15日 上午11:36:14
*/
public interface IProductService {

	public List<Product> queryByQueryVo(QueryVo vo);

}

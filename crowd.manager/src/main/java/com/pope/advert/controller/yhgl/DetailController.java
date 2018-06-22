
package com.pope.advert.controller.yhgl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("detail")
public class DetailController {
	@RequestMapping("index")
	public String xqfgzjdxq() {
		return "detail/xqfgzjdxq";
	}
}

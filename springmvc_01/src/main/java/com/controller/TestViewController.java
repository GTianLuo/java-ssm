package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** ThymeleafView
 *  1.当控制方法设置的视图名称(返回的字符串或者是通过ModelAndView设置的视图名称)没有任何前缀时，
 *    此时的视图名称会被配置文件中配置的视图解析器解析。因为我们这里配置的是ThymeleafViewResolver，所以这里的视图为ThymeleafViewResolver
 *
 *  2.InternalResourceView是SpringMVC默认的转发视图，需要在返回的字符串前面加"forward"，
 *    和Thymeleaf同样是转发，不同的是：ThymeleafView转发时的地址会被渲染，以及转发的页面如果有Thymeleaf语法的化也会被渲染。
 *
 *  3.RedirectView是重定向视图，需要在返回的字符串前面加"redirect:"，使用该视图实现的是客户端重定向，网页的地址栏是会发生改变的
 *   之前在JavaWeb时有说到：response.redirect("重定向地址")，这里的重定向地址是交给客户端解析的，"/"会被解析为:http://localhost:8080，
 *   但是在RedirectView实现重定向时会自动在前面添加上下文路径(工程路径)
 */

@Controller
public class TestViewController {

    @RequestMapping("/test/thymeleafview")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/test/internalresourceview")
    public String testInternalResourceView(){
        return "forward:/test/thymeleafview";
    }

    @RequestMapping("/test/redirectview")
    public String testRedirectView(){
        return "redirect:/test/thymeleafview";
    }

}

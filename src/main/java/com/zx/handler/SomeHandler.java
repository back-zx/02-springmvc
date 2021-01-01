package com.zx.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//定义处理器类
@Controller
@RequestMapping("/some")//相当于命名空间，可有可无
public class SomeHandler{

    @RequestMapping({"/first","/first2"})
    //@RequestMapping的类型是字符串数组，可以定义多个路径对应一个处理器方法
    public ModelAndView doFirst(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.addObject("message","Hello SpringMVC!");
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping("/second")
    public ModelAndView doSecond(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.addObject("message","执行doSecond方法!");
        mv.setViewName("welcome");
        return mv;
    }
    //@RequestMapping("/third*")//要求请求路径中的资源名称以third开头
    //@RequestMapping("/*third")//要求请求路径中的资源名称以third结尾
    //@RequestMapping("/*/third")//要求命名空间路径和请求路径的资源名称之间必须有一级路径
    @RequestMapping("/**/third")//要求命名空间路径和请求路径的资源名称之间可以匹配多级路径也可以没有
    public ModelAndView doThird(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.addObject("message","执行doThird方法!");
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping(value = "/fourth",method = RequestMethod.POST)
    //method作用是限制请求方式为post
    // 需在前台页面指定请求方式为post,即method="post"
    // 否则会出现405错误，因为服务器默认的请求方法为get
    public ModelAndView doFourth(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.addObject("message","执行doFourth方法!");
        mv.setViewName("welcome");
        return mv;
    }

    //要求请求中必须携带name参数(/some/fifth?name=aaa)
    @RequestMapping(value = "/fifth",params = "name")

    //要求请求中必须携带name参数和age参数(/some/fifth?name=aaa&age=20)
    //@RequestMapping(value = "/fifth",params = {"name","age"})

    //要求请求中绝对不能携带name参数,必须携带age参数(/some/fifth?age=20)
    //@RequestMapping(value = "/fifth",params = {"!name","age"})

    //要求请求中必须携带name参数且name=zx,必须携带age参数(/some/fifth?name=zx&age=20)
    //@RequestMapping(value = "/fifth",params = {"name=zx","age"})
    public ModelAndView doFifth(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.addObject("message","执行doFifith方法!");
        mv.setViewName("welcome");
        return mv;
    }
}

package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @ RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 *
 * @ RequestMapping 的method属性是一个RequestMethod类型数组，
 *   作用：通过请求方式来匹配请求的处理方法，因为大多数请求都是get方式，所以该属性默认为get方式
 *   例：@RequestMapping(value = {"/success","/success2"}, method = {RequestMethod.GET,RequestMethod.POST})
 *   在@RequestMapping基础上，结合请求方式派生一些新的注解：@GetMapping @PostMapping @DeleteMapping等
 *
 * @ RequestMapping 的param属性：
 * @ RequestMapping注解的params属性通过请求的请求参数匹配请求映射
 * @ RequestMapping注解的params属性是一个字符串类型的数组，可以通过四种表达式设置请求参数和请求映射的匹配关系
 * " param"：要求请求映射所匹配的请求必须携带param请求参数
 *"!param"：要求请求映射所匹配的请求必须不能携带param请求参数
 * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
 * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
 *  例：
 *  params = {"username","!age","gender!=男","password=123"}
 *  表示请求必须携带username属性；不能携带age属性；要么不携带gender属性，要么携带了gender属性但是该属性不等于男；必须携带password属性，并且值也等于123
 *
 *
 *
 *
 * @ RequestMapping注解的headers属性通过请求的请求头信息匹配请求映射
 * @ RequestMapping注解的headers属性是一个字符串类型的数组，可以通过四种表达式设置请求头信
 * 息和请求映射的匹配关系
 * "header"：要求请求映射所匹配的请求必须携带header请求头信息
 * "!header"：要求请求映射所匹配的请求必须不能携带header请求头信息
 * "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value
 * "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value
 * 若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，此时页面
 * 显示404错误，即资源未找到
 *
 *
 * SpringMVC支持ant风格的路径
 * ？：表示任意的单个字符(不能代表？本身 和 / )
 * *：表示任意的0个或多个字符(不能代表？本身 和 / )
 * **：表示任意层数的任意目录
 * 注意：在使用**时，只能单独写在两个斜线之间，不能与其它字符搭配使用，如：/**qqw/xxx
 *
 *
 * @ RequestMapping注解中使用路径中的占位符
 *传统风格路径：/index?id=1
 * rest风格：/index/1
 * 我们可以通过注解可以获取这个1
 * 第一步：RequestMapping的value属性设置的路径的后面加 {name}
 * 第二步：设置方法的参数，通过注解来获取这个值：@PathVariable Integer name
 *
 *
 * 获取请求参数的方式
 * 方式一：在控制方法中添加参数：HttpServletRequest request，DispatcherServlet在调用控制方法时会自动赋值
 *
 * 方式二：在控制方法添加参数，参数名和请求参数名相同，DispatcherServlet在调用控制方法时会自动赋值。
 *         若请求参数名和方法参数名不一致，我们可以通过注解 @RequestParam("请求参数名") Integer 方法参数名，将请求参数赋值给指定的方法参数
 *         @ RequestParam有一个属性，require，默认为true，表示这个参数是必须的，如果请求中没有这个参数就会报400错误
 *         @ RequestParam还有一个属性，defaultValue，如果获取不到该请求参数，就会拿这个默认值代替，如果设置了该属性，就不会报上面说的400错误
 *
 *
 * 方式三：当请求参数刚好是一个实体类的属性时，我们可以拿实体类方法参数来接收这些属性，前提是属性名和参数名必须一致
 *          当我们拿一个实体类来接受请求参数时，DispatcherServlet会自动调用无参构造，
 *          并且通过set方法将存在请求参数中存在实体属性赋值给对象，不存在的属性赋默认值。
 *
 * @ RequestHeader和@CookieValue分别是用来获取请求头信息，和cookie信息的，用法和RequestParam一样，只是想获取请求头信息和cookie信息注解不能省略
 *
 *
 * 设置post请求乱码问题
 *我们无法通过获取RequestServlet来设置编码，因为设置编码必须放在获取参数之前，不然设置无效，请求参数的获取是由DispatcherServlet提前获取的。
 * 我们只需要将SpringMVC提供的CharacterEncodingFilter配置到web.xml文件中就行了
 * 注意：该过滤器一般放在最前面，防止其它过滤器在执行过程中有获取参数的操作
 *
 *
 *  向域对象中共享数据
 * 1.向请求域共享数据：
 *  通过ModelAndView向请求域添加数据，并且进行页面转发
 *  普通返回字符串的控制方法底层就会拿这个返回的字符串封装成一个ModalAndView
 *  所以我们这里可以直接返回一个ModalAndView
 *  我们还可以使用Model、ModelMap、Map来向请求域共享数据，下面有例子。
 * 2.向session和application域共享数据一般采用获取Request的方式，然后使用JavaWeb中的方式共享
 *
 */



//若在此处加上：@RequestMapping("/test")，那么想要请求下面的success方法必须要：/test/success
@Controller
public class ControllerFirst {
    //当web请求为 "工程路径/"时会执行该方法
    @RequestMapping("/")
    public String protal(){
        //控制器会将页面跳转到逻辑视图：index
        //thymeleaf会将逻辑视图加上前缀和后缀变成物理视图：/WEB-INF/templates/index.html
        return "index";
    }

    //一个控制器方法可以处理多个请求
    @RequestMapping(
            value = {"/success"}
            //value = {"/*success/{id}","/success"}
            //method = {RequestMethod.GET,RequestMethod.POST},
            //params = {"username","!age","gender!=男","password=123"}
            )
    public String success( Integer id, @RequestParam(value = "Age",defaultValue = "18") Integer age ){
        System.out.println(id);
        return "success";
    }

    /**
     *测试获取请求头信息
     */
    @RequestMapping("/testone")
    public String testGetRequestHeader(@RequestHeader("sec-ch-ua-platform") String platfrom){
        System.out.println(platfrom);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testpojo(User user){
        System.out.println(user);
        return "success";
    }


    @RequestMapping("/testtwo")
    public String testGetCookie(@CookieValue("JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "success";
    }

    @RequestMapping("/testfour")
    public String testCharacter(){
        return "character";
    }

    @RequestMapping("/testfive")
    public String testCharacter2(String test){
        System.out.println(test);
        return "success";
    }

    @RequestMapping("/testmav")
    public ModelAndView testMav(){
        ModelAndView mav = new ModelAndView();
        //向请求域添加数据
        mav.addObject("operation","test ModelAndView");
        //页面转发
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testmodel")
    public String testModel(Model model){
        model.addAttribute("operation","test model");
        return "success";
    }

    @RequestMapping("/testmodelmap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("operation","test ModelMap");
        return "success";
    }


    @RequestMapping("/testmap")
    public String testMap(Map<String,Object> map){
        map.put("operation","test Map");
        return "success";
    }

    @RequestMapping("/testsession")
    public String testSession(HttpSession session){
        session.setAttribute("operation","test session");
        return "success";
    }

    @RequestMapping("/testapplication")
    public String testApplication(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("operation","test application");
        return "success";
    }






}

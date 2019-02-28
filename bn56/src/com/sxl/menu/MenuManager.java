package com.sxl.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sxl.entity.AccessToken;
import com.sxl.util.WeixinUtil;

public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);
    //描述:菜单管理器类 
    public static void main(String[] args) {
        // 第三方用户唯一凭证
        String appId = "wx0afa7b86059ecc20";
        // 第三方用户唯一凭证密钥
        String appSecret = "8bcd8eb9ef6a5d041da17fe44d8c3439";

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("查看个人信息");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12 = new CommonButton();
        btn12.setName("课程查询");
        btn12.setType("click");
        btn12.setKey("12");

        CommonButton btn13 = new CommonButton();
        btn13.setName("成绩查询");//设置二级子菜单名
        btn13.setType("click");//设置菜单点击类型为 点击事件
        btn13.setKey("13");//子菜单对应key值用于判断具体完成的功能

        CommonButton btn14 = new CommonButton();
        btn14.setName("考试信息查询");
        btn14.setType("click");
        btn14.setKey("14");

        CommonButton btn15 = new CommonButton();
        btn15.setName("用户绑定");
        btn15.setType("click");
        btn15.setKey("15");

        
        

        CommonButton btn21 = new CommonButton();
        btn21.setName("三球联赛");
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn22 = new CommonButton();
        btn22.setName("成绩单办理流程");
        btn22.setType("click");
        btn22.setKey("22");
       
        CommonButton btn23 = new CommonButton();
        btn23.setName("优秀本科生实践");
        btn23.setType("click");
        btn23.setKey("23");
       
        CommonButton btn24 = new CommonButton();
        btn24.setName("四六级报名");
        btn24.setType("click");
        btn24.setKey("24");
       

        CommonButton btn31 = new CommonButton();
        btn31.setName("系统介绍");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("日历");
        btn32.setType("view");//子菜单点击类型为view 为链接跳转
        btn32.setUrl("https://wannianrili.51240.com/");//设置key值 当消息类型为view时设置key值为
                                                        //url

        CommonButton btn33 = new CommonButton();
        btn33.setName("假期返程查询");
        btn33.setType("view");
        btn33.setUrl("http://www.ctrip.com/");
        
       

        
        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
        
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("个人中心");
        //一级下有五个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14, btn15});

        
        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("校园生活");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24});

        
        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("更多信息");
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33});

        
        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}
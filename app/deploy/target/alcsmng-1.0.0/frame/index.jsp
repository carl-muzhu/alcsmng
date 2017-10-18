<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<head>
    <title>催收管理系统</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link type="text/css" rel="stylesheet" href="../resources/css/fonts.css"/>
    <link type="text/css" rel="stylesheet" href="../frame/css/head.css"/>
</head>
<body>
<div class="wrapper">
    <div class="head">
        <div class="head_top">
            <div class="head_logo">
                <a href="#" class="logo"><h2 class="word">盈盈理财催收平台</h2></a>
            </div>
            <div class="head_oper">
                <ul class="head_nav">
                    <li>
                        <i class="user"></i><span>您好，用户</span>
                    </li>
                    <li id="changePassword" class="cursor"><i class="password"></i><span>修改密码</span></li>
                    <li id="loginOut" class="cursor"><i class="loginOut"></i><span>退出</span></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="mainContent">
        <div class="leftColumn">
            <ul class="menus">
                <li class="menu_item m_close">
                    <div class="item_icon power_icon"></div>
                    <p class="item_title">催收管理</p>
                    <div class="arrow_icon arrow_down"></div>
                </li>
                <li class="second_item hide">
                    <ul>
                        <li id="platformUserManage">分案设置</li>
                        <li id="roleManage">案件查看</li>
                    </ul>
                </li>
                <li class="menu_item m_close">
                    <div class="item_icon power_icon"></div>
                    <p class="item_title">工作列表</p>
                    <div class="arrow_icon arrow_down"></div>
                </li>
                <li class="second_item hide">
                    <ul>
                        <li id="hugUserManage">我的案件</li>
                        <li id="hugUserAuthenticationManage">我的回款</li>
                    </ul>
                </li>
                <li class="menu_item m_close">
                    <div class="item_icon power_icon"></div>
                    <p class="item_title">系统管理</p>
                    <div class="arrow_icon arrow_down"></div>
                </li>
                <li class="second_item hide">
                    <ul>
                        <li id="hugHospManage">用户管理</li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="rightContent">
            <div class="rightColumn">
                <iframe id="mainFrame" width="100%" height="100%" scrolling="no" frameborder="0" marginwidth="0"
                        marginheight="0" src=""></iframe>
            </div>
        </div>
    </div>
    <div class="bottom">
        <p>Copyright © 2017 杭州盈火科技有限公司 </p>
    </div>
</div>
<script type="text/javascript" src="../resources/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.nicescroll.min.js"></script>
<script type="text/javascript" src="../resources/artdialog/artDialog.source.js?skin=blue2"></script>
<script type="text/javascript" src="../resources/artdialog/iframeTools.source.js"></script>
<script type="text/javascript">
    window.onload = function () {
        change();
        $(".menu_item:eq(9)").click();
        $("#featureArticleManage").click();
    };
    $(window).resize(function () {
        change();
    });
    function change() {
        $(".mainContent").height($(window).height() - 76);
        $(".rightColumn").height($(window).height() - 76 - 26);
        $(".leftColumn").height($(window).height() - 76);
    }
    //加载审核人数
    function queryCount() {
        $.ajax({
            type: "POST",
            url: "index!queryCount.htm",
            success: function (data) {
                $("#count").text(data.count);
            },
            error: function () {
            }
        });
    }
    $(function () {
        queryCount();
        //滚动条
        $(".leftColumn").height($(window).height() - 76);
        $(".leftColumn").niceScroll({
            railpadding: {top: 0, right: 0, left: 0, bottom: 0},
            cursorborder: "",
            cursoropacitymin: 0,
            cursoropacitymax: 0.2,
            cursorcolor: "#000000",
            zindex: "99",
            cursorwidth: "9px"
        });
        //注销
        $("#loginOut").click(function () {
            window.location.href = "../index/logout.htm";
        });
        //修改密码
        $("#changePassword").click(function () {
            art.dialog.open("permissionManage/userAction!toUpdatePassword.htm", {
                width: 400,
                height: 300,
                lock: true,
                resize: false,
                title: '密码修改'
            });
        });
        //菜单上下显示与隐藏
        $(".menu_item").click(function () {
            if ($(this).hasClass("m_open")) {
                $(this).removeClass("m_open").addClass("m_close");
                $(this).find(".arrow_icon").removeClass("arrow_up").addClass("arrow_down");
                $(this).next().removeClass("show").addClass("hide");
                $(this).next().next(".third_item").removeClass("show").addClass("hide");
            } else if ($(this).hasClass("m_close")) {
                $(this).removeClass("m_close").addClass("m_open");
                $(this).find(".arrow_icon").removeClass("arrow_down").addClass("arrow_up");
                $(this).next().removeClass("hide").addClass("show");
            }
        });
        //二级菜单去掉和添加选中样式
        $(".second_item").find("li").click(function () {
            if (!($(this).hasClass("m_open") || $(this).hasClass("m_close"))) {
                $(".current").removeClass("current");
                $(this).addClass("current");
            }
            if ($(this).hasClass("m_open")) {
                $(this).removeClass("m_open").addClass("m_close");
                $(this).find(".jt_down").removeClass("jt_down").addClass("jt_up");
                $(this).parents("li").next().removeClass("show").addClass("hide");
            } else if ($(this).hasClass("m_close")) {
                $(this).removeClass("m_close").addClass("m_open");
                $(this).find(".jt_up").removeClass("jt_up").addClass("jt_down");
                $(this).parents("li").next().removeClass("hide").addClass("show");
            }
        });
        //三级菜单去掉和添加选中样式
        $(".third_item").find("li").click(function () {
            $(".current").removeClass("current");
            $(this).addClass("current");
        });

        //随访规则模板管理
        $("#ruleManage").click(function () {
            $("#mainFrame").attr("src", "module/ruleAction!toRuleScrubber.htm");
        });
        //宣教模板管理
        $("#education").click(function () {
            $("#mainFrame").attr("src", "../template/toEducationListPage.htm");
        });
        //权限管理
        $("#userSuggestion").click(function () {
            $("#mainFrame").attr("src", "hugUserManage/hugUserAction!toUserSuggestionList.htm");
        });
        //角色管理
        $("#roleManage").click(function () {
            $("#mainFrame").attr("src", "../role/toRoleList.htm");
        });
        //平台用户管理
        $("#platformUserManage").click(function () {
            $("#mainFrame").attr("src", "../user/toUserList.htm");
        });
        //权限管理
        $("#permissionManage").click(function () {
            $("#mainFrame").attr("src", "../permission/toPermissionTree.htm");
        });
        //用户认证管理
        $("#hugUserAuthenticationManage").click(function () {
            $("#mainFrame").attr("src", "hugUserManage/hugUserAction!toUserList.htm");
        });
        //hug医院信息管理
        $("#hugHospManage").click(function () {
            $("#mainFrame").attr("src", "hugHospitalManage/hospitalAction!toHospitalList.htm");
        });
        //esb医院信息管理
        $("#esbHospitalManage").click(function () {
            $("#mainFrame").attr("src", "../template/toEducationListPage.htm");
        });
        //esb接口管理
        $("#esbInterfaceManage").click(function () {
            $("#mainFrame").attr("src", "esbHospitalManage/interfaceAction!toInterfaceList.htm");
        });

        //知识库－疾病管理
        $("#diseaseManage").click(function () {
            $("#mainFrame").attr("src", "knowledgeLibManage/diseaseAction!toDiseaseList.htm");
        });
        //知识库－药品管理
        $("#drugManage").click(function () {
            $("#mainFrame").attr("src", "knowledgeLibManage/drugAction!toDrugList.htm");
        });
        //知识库－急救管理
        $("#emergencyManage").click(function () {
            $("#mainFrame").attr("src", "knowledgeLibManage/emergencyAction!toEmergencyList.htm");
        });
        //知识库－医院管理
        $("#hospitalManage").click(function () {
            $("#mainFrame").attr("src", "knowledgeLibManage/hospitalAction!toHospitalList.htm");
        });
        //患者端广告页管理
        $("#patientAdvertisementManage").click(function () {
            $("#mainFrame").attr("src", "advertisementManage/advertisementAction!toPatientAdvertisementList.htm");
        });
        //医生端广告页管理
        $("#doctorAdvertisementManage").click(function () {
            $("#mainFrame").attr("src", "advertisementManage/advertisementAction!toDoctorAdvertisementList.htm");
        });
        //短信H5广告页管理
        $("#HTML5AdvertisementManage").click(function () {
            $("#mainFrame").attr("src", "advertisementManage/advertisementAction!toHTML5AdvertisementList.htm");
        });
        //hug用户管理
        $("#hugUserManage").click(function () {
            $("#mainFrame").attr("src", "hugUserManage/hugUserAction!toUserManage.htm");
        });
        //账户流程管理-审核人员
        $("#accountForExamine").click(function () {
            $("#mainFrame").attr("src", "followHospitalManage/hospitalAccountAction!toExamineTitle.htm");
        });
        //账户流程管理-处理人员
        $("#accountForHandle").click(function () {
            $("#mainFrame").attr("src", "followHospitalManage/hospitalAccountAction!toHandleTitle.htm");
        });
        //账户流程管理-项目经理代金券
        $("#accountForApply").click(function () {
            $("#mainFrame").attr("src", "followHospitalManage/hospitalAccountAction!toApplyTitle.htm");
        });
        //账户流程管理-管理员
        $("#accountForManage").click(function () {
            $("#mainFrame").attr("src", "followHospitalManage/hospitalAccountAction!toAccountList.htm");
        });
        //医院信息管理
        $("#hospitalInfoManage").click(function () {
            $("#mainFrame").attr("src", "../server/toServerTreePage.htm");
        });
        //用户消息
        $("#userMessage").click(function () {
            $("#mainFrame").attr("src", "hugUserManage/hugUserAction!toUserMessage.htm");
        });
        //蓝牛公告管理
        $("#lanniuNoticeManage").click(function () {
            $("#mainFrame").attr("src", "noticeManage/noticeAction!toNoticeList.htm");
        });
        //专题管理
        $("#featureArticleManage").click(function () {
            $("#mainFrame").attr("src", "featureManage/featureAction!toFeatureTree.htm");
        });
        //医生账户管理
        $("#doctorAccountManage").click(function () {
            $("#mainFrame").attr("src", "doctorAccountManage/doctorAccountAction!toDoctorAccountList.htm");
        });
        //提现审核
        $("#cashForExamine").click(function () {
            $("#mainFrame").attr("src", "doctorAccountManage/doctorAccountAction!toCashExamineTitle.htm");
        });
        //提现处理
        $("#cashForHandle").click(function () {
            $("#mainFrame").attr("src", "doctorAccountManage/doctorAccountAction!toCashHandleTitle.htm");
        });
        //退款管理
        $("#refundManage").click(function () {
            $("#mainFrame").attr("src", "refundManage/refundAction!toRefundList.htm");
        });
        //部门管理
        $("#sectionManage").click(function () {
            $("#mainFrame").attr("src", "registerManage/registerManageAction!toSectionManage.htm");
        });
        //科室管理
        $("#deptManage").click(function () {
            $("#mainFrame").attr("src", "registerManage/registerManageAction!toDeptManage.htm");
        });
        //医院配置管理
        $("#commonParamManage").click(function () {
            $("#mainFrame").attr("src", "commonParamManage/commonParamManageAction!toCommonParamManage.htm");
        });
        //新闻资讯管理
        $("#newsManage").click(function () {
            $("#mainFrame").attr("src", "newsManage/newsAction!toNewsList.htm");
        });
    });
</script>
</body>
</html>
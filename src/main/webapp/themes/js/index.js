/*
* @Author: asus
* @Date:   2018-11-01 11:24:57
* @Last Modified by:   asus
* @Last Modified time: 2018-11-06 17:00:12
*/

'use strict';
$(function() {
	 $('.nav-scroll').niceScroll({
        cursorcolor: "#000",//#CC0071 光标颜色
        cursoropacitymax: 1, //改变不透明度非常光标处于活动状态（scrollabar“可见”状态），范围从1到0
        cursorwidth: "5px", //像素光标的宽度
        cursorborder: "0", // 游标边框css定义
        autohidemode: "scroll" //是否隐藏滚动条
    });
    var NICE = $('.nav-scroll').getNiceScroll();


	// 菜单动效
    $(".snavbar").on("click",".lis",function (e) {
        e.stopPropagation();//阻止冒泡
        if($(this).hasClass("open")){
            $(this).children(".lis-out").slideUp("fast",function(){
                $(this).parent().removeClass('open');
            });
            $(this).children("a").children(".fl.glyphicon").removeClass("rotate");
        }else{
            $(this).siblings(".open").children(".lis-out").slideUp("fast",function(){
                $(this).parent().removeClass('open');
            });
            $(this).children(".lis-out").slideDown("fast",function(){
                $(this).parent().addClass('open');
            });
            $(this).siblings(".open").children("a").children(".fl.glyphicon").removeClass("rotate");
            $(this).children("a").children(".fl.glyphicon").addClass("rotate");
        }
    });
    //菜单缩进动效
	$('.jiantou').click(function(){
		if ($(this).hasClass('smjt')) {
			$(this).removeClass('smjt');
            $('.open').removeClass('open');
            $('.rotate').removeClass('rotate');
            $('.lis-out').hide();
            $('.mainbody').removeClass('suo');
            setTimeout(function () {
                $(".yiji > a > span,.yiji > a > .fr").show();
                NICE.resize();
            },200)
		}else{
            $(".yiji > a > span,.yiji > a > .fr").hide();
			$('.open').removeClass('open');
            $('.rotate').removeClass('rotate');
			$('.lis-out').hide();
			$(this).addClass('smjt');
            $('.mainbody').addClass('suo');
		}
	});
	/*点击变色*/
   $(".lis-out > li > a").click(function(){
        $(this).addClass("chose").parents().siblings().find("a").removeClass("chose");
     //    $(this).parents().siblings().find(".erji").hide(300);	
	    // $(this).siblings(".erji").toggle(300);	
	});

      //刷新iframe
     $('.head-tabs .page-tabs').delegate('.page-tabs-content','dblclick',function(){
         var xx = $(this).index();
         $('.head-tabs .page-tabs .page-tabs-content').removeClass('active').eq(xx).addClass('active');
         var target = $('#main iframe').eq(xx);
         var url = target.attr('src').split("?",1) + "?" + Math.random();
         //显示loading提示
         var loading = layer.load();
         target.attr('src', url).load(function () {
             //关闭loading提示
             layer.close(loading);
         });
     });

    // 通过关闭按钮关闭iframe及选项卡
    $('.head-tabs .page-tabs').delegate('.page-tabs-content span','click',function(){
        var y = $(this).parent().parent().index();
        $(this).parent().parent().remove();
        $('#main iframe').eq(y).remove();
    });
    //关闭全部选项卡
    $('.tabCloseAll').click(function(){
//      $('.page-tabs-content-out').children("[data-id]").not(":first").each(function () {
//          $('#main iframe[data-id="' + $(this).attr('data-id') + '"]').remove();
//          $(this).remove();
//      });
//      $('.page-tabs-content-out').children("[data-id]:first").each(function () {
//          $('#main iframe[data-id="' + $(this).attr('data-id') + '"]').show();
//          $(this).addClass("active");
//          $('#main iframe:first').show();
//      });
        $(".page-tabs-content-out").children(".page-tabs-content").not(":first").remove();
        $(".page-tabs-content-out").children(".page-tabs-content:first").addClass("active");
        $("#main iframe").not(":first").remove();
        $("#main iframe:first").show();
        $(".lis-a.sele").removeClass("sele");
        $('.page-tabs-content-out').css("margin-left", "0");
    });
    //关闭其他选项卡
    $('.tabCloseOther').click(function(){
        $('.page-tabs-content-out').children("[data-id]").not(":first").not(".active").each(function () {
            $('#main iframe[data-id="' + $(this).attr('data-id') + '"]').remove();
            $(this).remove();
        });
        var actives_did = $(".page-tabs-content-out").children(".page-tabs-content.active").attr('data-id');
        $(".lis-a").removeClass("sele");
        $('.lis-a[data-id="' + actives_did + '"]').addClass("sele");
        $('.page-tabs-content-out').css("margin-left", "0");
    });

    // 左移按扭
   
 
});



layui.use('element', function(){
  var $ = layui.jquery
  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
  
  //触发事件
  var active = {
    tabAdd: function(){
      //新增一个Tab项
      element.tabAdd('demo', {
        title: '新选项'+ (Math.random()*1000|0) //用于演示
        ,content: '内容'+ (Math.random()*1000|0)
        ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
      })
    }
    ,tabDelete: function(othis){
      //删除指定Tab项
      element.tabDelete('demo', '44'); //删除：“商品管理”
      
      
      othis.addClass('layui-btn-disabled');
    }
    ,tabChange: function(){
      //切换到指定Tab项
      element.tabChange('demo', '22'); //切换到：用户管理
    }
  };
  
  $('.site-demo-active').on('click', function(){
    var othis = $(this), type = othis.data('type');
    active[type] ? active[type].call(this, othis) : '';
  });
  
  //Hash地址的定位
  var layid = location.hash.replace(/^#test=/, '');
  element.tabChange('test', layid);
  
  element.on('tab(test)', function(elem){
    location.hash = 'test='+ $(this).attr('lay-id');
  });
  
});

layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'/demo/table/user/'
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,cols: [[
      {field:'id', title: 'ID', sort: true}
      ,{field:'username', title: '用户名'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
      ,{field:'sex', title: '性别', sort: true}
      ,{field:'city', title: '城市'}
      ,{field:'sign', title: '签名'}
      ,{field:'classify', title: '职业', align: 'center'} //单元格内容水平居中
      ,{field:'experience', title: '积分', sort: true, align: 'right'} //单元格内容水平居中
      ,{field:'score', title: '评分', sort: true, align: 'right'}
      ,{field:'wealth', title: '财富', sort: true, align: 'right'}
    ]]
  });
});
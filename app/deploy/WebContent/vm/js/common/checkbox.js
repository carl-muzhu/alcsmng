(function($){

 var option={
     isEdit:false,  //�Ƿ���Ա༭:Ĭ���Ƿ�
     Listheight:200,  //������߶�
     ListWidth:0,     //�����򳤶�
     //����Դ
     data:[
           {"value":1,"text":"ѡ��1"},
           {"value":2,"text":"ѡ��2"},
           {"value":3,"text":"ѡ��3"},
           {"value":4,"text":"ѡ��4"}
           ]
     };
           //��ʼ����������
          function Start(obj)
          {
              if(!option.isEdit)
              {
              obj.attr({"readonly":"readonly"});
              }
            var      myList=$("<div></div>");
            var  ul=$("<ul></ul>");
           ul.css({"list-style":"none","margin":"0px","padding":"2px"});
           myList.css({"border":"1px solid #D9E5F3","position":"absolute","overflow-y":"scroll","background-color":"#fff","font-size":"14px"});
           if(option.Listheight<=0)
           {
               option.Listheight=200;
            }
           myList.height(option.Listheight);
           if(option.ListWidth<=0)
           {
             option.ListWidth=obj.width();
           }
              myList.width(option.ListWidth);
            //Ĭ��λ�����ڴ���Ԫ�ص��·�
           myList.offset({"top":obj.offset().top+obj.outerHeight(),"left":obj.offset().left});
           var data=option.data;

           if(data.length>0)
           {
          for(var i=0;i<data.length;i++)
          {
             var li=$("<li/>");
              var ListSon=$("<input type='checkbox' />");
             ListSon.change(function(){
                    if(this.checked)    
                    {
                        obj.val(obj.val()+$(this).val());
                    }
                    else
                    {
                        obj.val(obj.val().replace($(this).val(),""));
                    }
                     });
              myList.mouseover(function(){
                            myList.show();           
                        });
             myList.mouseout(function(){
                            myList.hide();           
                        });
             var span=$("<span></span>");
             span.text(data[i].text);
               ListSon.val(data[i].value+";");
              li.append(ListSon);
             li.append(span);
             ul.append(li);
          }
           }
             myList.append(ul);
               myList.appendTo("body");
             myList.hide();

            FoucsShow($(obj),myList);
          }
          // ����ȡ������ʹ���ָ�������
          function FoucsShow(obj,myList)
          {
              obj.focus(function(){myList.show();});
          };
          $.fn.createList=function(newoption)
          {
              $.extend(option,newoption);
             Start($(this));

          };
          })(jQuery);
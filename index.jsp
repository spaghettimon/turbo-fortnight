<%@page import="xyz.Start"%>
<%@page import="xyz.S1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<jsp:useBean id="tab" class="xyz.Start"/>

    <h1>Select:</h1>
    
    <select id="table" name="seal">
        <option value=" "></option>
   <% List table=tab.getTable();
   Iterator i=table.iterator();
   while(i.hasNext()){
     Start s=(Start)i.next();
     out.print("<option value=\""+s+"\">"+s+"</option>");
   }
   
   %>
   </br>
    </select>
   <div id="form1"></div>
   <p id="x"></p>
   <div id="tabPrint"></div>
   <script>
   var e = document.getElementById("table");
   e.onchange = function bclick(){
       var x= document.getElementById("x");
       var form=document.createElement("form");
       form.id="fid";
       form.action="index.jsp";
       form.method="post";
       var hform=document.createElement("input");
       hform.type="hidden";
       hform.name="hid";
       hform.value=e.value;
       var sbutton=document.createElement("input");
       sbutton.type="submit";
       sbutton.value="click";
       sbutton.form="fid";
       form.appendChild(hform);
       var formChildren=form.childNodes;
       if(formChildren[1]){
       form.replaceChild(sbutton,formChildren[1]);}
   else{
       form.appendChild(sbutton);
   }
       
       var fdiv=document.getElementById("form1");
       fdiv.appendChild(form);
     // x.innerHTML=hform.value;
    }
         
      
  </script>
  <%
   
       List table1=tab.dispT1();
   Iterator j=table1.iterator();
  %>
 
 <% 
     String val=request.getParameter("hid");
     if(val!=null){
     out.println(val);
     if(val.equals("Table 1")){
 %> 
 <form method="post"> 
      <table border="1">
     <TR>
            <TH>ID</TH>
            <TH>NAME</TH>
            <TH>AGE</TH>
            <TH>ADDRESS</TH>
            <TH>   </TH>
           
        </TR> 
 <%  String h="<a href\"=index.jsp\">"+"edit"+"</a>" ; 
    int count=0;
    int sno=0;
     while(j.hasNext()){
     S1 m1=(S1)j.next();   
        count++;
        sno++;
         out.print("<tr><td>"+m1.getId()+"</td>"+"<td>"+m1.getName()+"</td>"+"<td>"+m1.getAge()+"</td>"+"<td>"+m1.getAddress()+"</td>"+"<td>"+"<input type=\"submit\" value=\"edit\" name=\"but"+count +"\">");
 }
     //<a href=\"" + "edit.jsp " + "onclick=\"return myFunc("+count+");\""+ "\">"+"EDIT"+sno+"</a>"+"</td></tr>
     String s= request.getParameter("count1");
   if(s!= "null"){
     session.setAttribute("c",s);`
     }
  
   }
}
 %>
 
 <script>
     function myfunc(var c){
         var uid=document.createElement("input");
         uid.type="hidden";
         uid.value=c;
         uid.name="count1";
         var v=document.getElementById("tabPrint");
         v.appendChild(uid);
        return true;
     }
  

}
      </script>
  </table> 
 </form>

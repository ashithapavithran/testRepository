<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <title>MRD Report</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href = "css-n-js/jquery-ui.css"
         rel = "stylesheet">
      
<script src="css-n-js/jquery-1.11.1.min.js"></script>

      <script src="css-n-js/jquery-ui.js"></script>
    </head>
    <style>
    .ui-dialog-titlebar {
          background:rgb(0, 136, 202);
    }
    .ui-icon-closethick{
    background-color:red;
 margin-top: -8px!important;
margin-left: -8px!important;
}
.button {
height:40px;
width:120px;
    background-color:#008CBA;
    border: none;
    color: white;
  
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
    </style>
  <script>
  function savestate(){
	  var add_state = document.getElementById('add_state').value;
	 
      if (add_state!=""){
          window.location.href="StateStore?add_state="+add_state;
      }
      else
         alert('Add State Name');
  }
  function savedis(){
	  var add_district = document.getElementById('add_district').value;
	  var state_name = document.getElementById('state_name').value;
	
      if (add_district!=""){
          window.location.href="Store?add_district="+add_district+ "&state_name=" + state_name;
      }
      else
         alert('Add District Name');
  }
  function closedis(){
	   $('#state_dialog').dialog('close');
  }
  </script>
     <script>
        $(document).ready(function() {
        	   
        			var answer =document.getElementById("state_name").value;				
        	           $.get('PopulateState?adviseType='+answer,function(responseJson) {
        				  
        				 if(responseJson!=null){
        					$("#state_name").empty();
        				  $.each(responseJson, function(key,value) { 
        				
        					  $("#state_name").append("<option value='"+value.male+"'>"+value.state_name+"</option>");
        				});
        				}
        	          }); 
        
        });
        </script>
           <script>
        $(document).ready(function() {
        	   
        			var answer =document.getElementById("state_name").value;
        	 $("#state_name").change(function(event){
        		var answer =document.getElementById("state_name").value;
        	           $.get('PopulateDistrict?adviseType='+answer,function(responseJson) {
        				  
        				 if(responseJson!=null){
        					$("#district_name").empty();
        				  $.each(responseJson, function(key,value) { 
        					  $("#district_name").append("<option>"+value.state_name+"</option>");
        				});
        				}
        	          }); 
        	});
        });
        </script>
        <script>
        function copy(){
        	
        	var el = document.getElementById('state_name');
        	var text = el.options[el.selectedIndex].innerHTML;
        	document.getElementById("staten").value=text;
        }
        </script>
        <script>
        $(function () {

            $("#state_dialog").dialog({
                modal: true,
                autoOpen: false,
                open: function(e) {
                    $(e.target).parent().css('background-color','#f6f6f6')},
                title: "Add State",
                width: 700,
                height:250
               
            });
            $("#addstate").click(function () {
                $('#state_dialog').dialog('open');
            });
            $("#dis_dialog").dialog({
                modal: true,
                autoOpen: false,
                open: function(e) {
                    $(e.target).parent().css('background-color','#f6f6f6')},
                title: "Add District",
                width: 700,
                height:250
               
            });
            $("#adddistrict").click(function () {
                $('#dis_dialog').dialog('open');
            });
        });
        </script>
 <body style="background-color: rgb(246, 246, 246);">
      
        <center>
            <table width="100%">
                <tr>
                    <td align="center" style="background-color: rgb(0, 136, 202)"><STRONG><FONT color="white" size="3">Add State/ District
                            </FONT></STRONG>
                    </td>
                </tr>
            </table>
        </center><br><br>
       
            <div id="testdiv1" align="center" style="position:absolute;visibility:hidden;background-color:#FFFFFF; z-index:1000;"></div>
            <table  bgcolor="white" align="center"  width="400" border="1" style="border-collapse:collapse" bordercolor="dimgray">

                <tr>
                    <td>
                        <TABLE id="tblRegNo" align="center" bgcolor="white" width="100%" >

                            <TR BGCOLOR="#eaf0f9">
                                <TD COLSPAN="2">

                                    <TABLE id="tbldaily" align="center" bgcolor="#FFFFFF" width="400" >                                      
                                        <TR BGCOLOR="#eaf0f9" height="40px">
                                            <TD>State Name</TD>
                                            <TD>
                                               <select id="state_name" name="state_name"  class="inputtextbold" style="width:200px;height:30px"> 
                                       
                                               </select>
                                            </TD>
                                        </TR>
                                        <TR BGCOLOR="#f6f6f6" height="40px">
                                            <TD>District Name</TD>
                                            <TD>
                                               <select id="district_name" name="district_name"   class="inputtextbold" style="width:200px;height:30px"></select>
                                            </TD>
                                        </TR>
                                         
                                    </TABLE>
                                </TD>
                            </TR>                            
                           
                        </TABLE>
                    </td>
                </tr>
            </table><br>
            <div align="center">
                                    <input type="button" id="addstate" name="btnSubmit" value="Add State" class="button button2"/>&nbsp;  
                                       <input type="button" id="adddistrict" name="btnSubmit" value="Add District" onclick="copy()" class="button button2"/>&nbsp;                            
                              </div>
            <form method="post" action="Store">
 <div id="state_dialog" class="ui-dialog" style="display:none;align:center">
<div class="">
    <div class="modal-dialog">
    
      <div class="modal-content">
        
  <div class="modal-body">
   <div id="testdiv1" align="center" style="position:absolute;visibility:hidden;background-color:#FFFFFF; z-index:1000;"></div>
<br><br>         
  <table  bgcolor="white" align="center"  width="400" border="1" style="border-collapse:collapse" bordercolor="dimgray">

                <tr>
                    <td>
                        <TABLE id="tblRegNo" align="center" bgcolor="white" width="100%" >

                            <TR BGCOLOR="#eaf0f9">
                                <TD COLSPAN="2">

                                    <TABLE id="tbldaily" align="center" bgcolor="#FFFFFF" width="400" >                                      
                                      
                                         <TR BGCOLOR="#f6f6f6">
                                            <TD>Add State name</TD>
                                            <TD>
                                                <input type="text" id="add_state" name="add_state"   class="inputtextbold" />
                                            </TD>
                                        </TR>
                                    </TABLE>
                                </TD>
                            </TR>                            
                            <TR BGCOLOR="#eaf0f9">
                                <TD align="center" colSpan="2">
                                  <input type="submit" id="showTable" name="btnSubmit" value="Save" onclick="savestate()">&nbsp;  
                                       <a href="main.jsp"><input type="button" id="showTable" name="btnSubmit" value="Close"></a>                           
                                </TD>
                            </TR>
                        </TABLE>
                    </td>
                </tr>
            </table>
   </div>
  
</div></div></div>
<pre id="display-json"></pre></div>
<div id="dis_dialog" class="ui-dialog" style="display:none;align:center">
<div class="">
    <div class="modal-dialog">
      <div class="modal-content">
        
  <div class="modal-body">
   <div id="testdiv1" align="center" style="position:absolute;visibility:hidden;background-color:#FFFFFF; z-index:1000;"></div>
           <br><br>
            <table  bgcolor="white" align="center"  width="400" border="1" style="border-collapse:collapse" bordercolor="dimgray">

                <tr>
                    <td>
                        <TABLE id="tblRegNo" align="center" bgcolor="white" width="100%" >

                            <TR BGCOLOR="#eaf0f9">
                                <TD COLSPAN="2">

                                    <TABLE id="tbldaily" align="center" bgcolor="#FFFFFF" width="400" >                                      
                                        <TR BGCOLOR="#eaf0f9">
                                            <TD>State Name</TD>
                                            <TD>
                                              <input type="text" id="staten" name="statename"  class="inputtextbold" style="width:180px;border-style:none;background-color:#eaf0f9" readonly> 
                                       
                                            </TD>
                                        </TR>
                                       
                                         <TR BGCOLOR="#f6f6f6">
                                            <TD>Add district name</TD>
                                            <TD>
                                                <input type="text" id="add_district" name="add_district"   class="inputtextbold" />
                                            </TD>
                                        </TR>
                                    </TABLE>
                                </TD>
                            </TR>                            
                            <TR BGCOLOR="#eaf0f9">
                                <TD align="center" colSpan="2">
                                  <input type="submit" id="showTable" name="btnSubmit" value="Save" onclick="savedis()">&nbsp;  
                                  <a href="main.jsp"><input type="button" id="showTable" name="btnSubmit" value="Close" "></a>                             
                                </TD>
                            </TR>
                        </TABLE>
                    </td>
                </tr>
            </table>
   </div>
  
</div></div></div>
<pre id="display-json"></pre></div>
  </form>  </body>
</html>

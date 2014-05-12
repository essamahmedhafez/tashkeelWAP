function checkFirstHint() {
  if (window.XMLHttpRequest) {
    // code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp1=new XMLHttpRequest();
  } else { // code for IE6, IE5
    xmlhttp1=new ActiveXObject("Microsoft.XMLHTTP");
  }

  xmlhttp1.onreadystatechange=function() {
    if (xmlhttp1.readyState==4 && xmlhttp1.status==200) {
      if (xmlhttp1.readyState==4 && xmlhttp1.status==200) {
        xmlhttp1.responseText;
        if(xmlhttp1.responseText != "0"){
          var button = document.getElementById("firstHint");
          var dataVal = button.getAttribute("data-content");
          
          var tanween_maksoor_exist = (xmlhttp1.responseText.indexOf("ٍ")>=0);
          if(tanween_maksoor_exist){
            document.getElementById("tanween_maksoor").style.visibility = "visible";
          }
          var kasraExist = (xmlhttp1.responseText.indexOf("ِ")>=0);
          if(kasraExist){
            document.getElementById("kasra").style.visibility = "visible";
          }
          var tanween_madmoon_exist = (xmlhttp1.responseText.indexOf("ٌ")>=0);
          if(tanween_madmoon_exist){
            document.getElementById("tanween_madmoon").style.visibility = "visible";
          }
          var dammaExist = (xmlhttp1.responseText.indexOf("ُ")>=0);
          if(dammaExist){
            document.getElementById("damma").style.visibility = "visible";
          }
          var tanween_maftoo7_exist = (xmlhttp1.responseText.indexOf("ً")>=0);
          if(tanween_maftoo7_exist){
            document.getElementById("tanween_maftoo7").style.visibility = "visible";
          }
          var fat7aExist = (xmlhttp1.responseText.indexOf("َ")>=0);
          if(fat7aExist){
            document.getElementById("fat7a").style.visibility = "visible";
          }
          var sekonExist = (xmlhttp1.responseText.indexOf("ْ")>=0);
          if(sekonExist){
            document.getElementById("sekon").style.visibility = "visible";
          }
          var shaddaExist = (xmlhttp1.responseText.indexOf("ّ")>=0);
          if(shaddaExist){
            document.getElementById("shadda").style.visibility = "visible";
          }




        }
      }
    }
  }
  session_num = document.getElementById("hiddenSession_num").innerHTML;
  xmlhttp1.open('GET','/solve1?session_num='+session_num,true);
  xmlhttp1.send();
}

setInterval(function(){
		checkFirstHint();
},1000);

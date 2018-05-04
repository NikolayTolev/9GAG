var model=document.getElementsByClassName('model-upload-p')[0];
var closeBtn=document.getElementsByClassName('closeBtnPost')[0];
var closeBtn2=document.getElementsByClassName('closeBtnPost')[1];
var p=document.getElementsByClassName("upload-post")[0];
var divUpload=document.getElementsByClassName("upload-model")[0];
closeBtn.addEventListener("click",closeModelPost);
window.addEventListener('click',clickOutsidePost);

function openModelPost(){
    model.style.display ='block';
    p.style.display="block";
    divUpload.style.display="none";
}

function closeModelPost(){
   model.style.display ='none';
}

function clickOutsidePost(e){
    if(e.target==model){
    model.style.display ='none';
    }
 }

function postUpload(){
    p.style.display="none";
    divUpload.style.display="block";
}

//document.getElementById('ajax-upload').addEventListener("submit", function(e){
//    e.preventDefault()
//    var form = e.target
//    var data = new FormData(form)
//            
//    var request = new XMLHttpRequest()
//            
//    request.onreadystatechange = function(){
//    	
//    }
//            
//    request.open(form.method, form.action)
//    request.send(data)
//})

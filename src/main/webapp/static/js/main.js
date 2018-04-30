//get the model element
var model=document.getElementById('simpleModel');

//get the open model button

var modelBtn=document.getElementById('modelBtn');

//get close button
var closeBtn=document.getElementsByClassName('closeBtn')[0];

//Listen for click
modelBtn.addEventListener("click",openModel);
//Listen for close click
closeBtn.addEventListener("click",closeModel);

//Listen for outside click
window.addEventListener('click',clickOutside);

//function to open model
function openModel(){
    model.style.display='block';
}

//function to close model 

function closeModel(){
   model.style.display ='none';
}

//function to close model if outside click
function clickOutside(e){
    if(e.target==model){
    model.style.display ='none';
    }
 }
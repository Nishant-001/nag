var form = document.getElementById("f1");
function handleForm(event) { event.preventDefault(); } 
form.addEventListener('submit', handleForm);
const element=document.getElementById("submit");
element.addEventListener("click",displayDetails);
var listitems= [];
function displayDetails(){
    
    let name=document.getElementById("Name");
    let email=document.getElementById("Email");
    let website=document.getElementById("Website");
    let image_link=document.getElementById("Image-Link");
    var skill=[];
    document.getElementById("Java").checked && skill.push("Java");
    document.getElementById("HTML").checked && skill.push("HTML");
    document.getElementById("CSS").checked && skill.push("CSS");

    let gender="";
    name.className="";
    email.className="";
    website.className="";
    image_link.className="";
    if(name.value==""){
        
        name.className="form-control is-invalid";
        alert("Input valid Name");
        return;
    }
    if(email.value==""){
        email.className="form-control is-invalid";
        alert("Input valid Email");
        return;
    }
    if(website.value==""){
        website.className="form-control is-invalid";
        alert("Input valid Website");
        return;
    }
    if(image_link.value==""){
        image_link.className="form-control is-invalid";
        alert("Input valid Image-Link");
        return;
    }

    
    try{
    gender=document.querySelector('input[name="Gender"]:checked').value;
    }
    catch(er){
        alert("Select Gender");
        return;
    }
    if(skill.length==0){
        alert("Select atLeast one skill");
        return;
    }
    let value={
        name:name.value,
        email:email.value,
        website:website.value,
        image_link:image_link.value,
        skill:skill,
        gender:gender
    };
    let table=document.getElementById("StudentInfo");
    document.getElementById("h2").style.display="block"; 

        let tr=document.createElement("tr");
        tr.className="fadeIn";
        let td1=document.createElement("td");
        let td2=document.createElement("td");
        let desc=`
        <div class="trow">
            <div id="name"> ${value.name}</div>
            <div> ${value.gender}</div>
            <div> ${value.email}</div>
            <a href=" ${value.website}" target="_blank" rel="noopener noreferrer">${value.website}</a>
            <div> ${value.skill.toString()}</div>
        </div>
        `;
        td1.innerHTML=desc;
        td2.innerHTML=`<img src="${value.image_link}" width="80px" height="100px">`;
        tr.appendChild(td1);
        tr.appendChild(td2);
        table.appendChild(tr);


    form.reset();

}

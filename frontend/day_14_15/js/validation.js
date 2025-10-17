function login() {
   
    // You can perform login validation and authentication here
    // For simplicity, let's just display an alert
    const username=document.getElementById("loginUsername").value;
    const password=document.getElementById("loginPassword").value;
    console.log(`Login clicked. Username: ${username}, Password: ${password}`);

}

function register() {
   

    // Frontend validation for registration form
    const name=document.getElementById("registerName").value;
    const email=document.getElementById("registerEmail").value;
    const username=document.getElementById("registerUsername").value;
    const password=document.getElementById("registerPassword").value;
    console.log(`Register clicked. Name: ${name}, Email: ${email}, Username: ${username}, Password: ${password}`);
    

    // Validate email format
    
    // Validate username (no special characters)
    

    // Validate password (at least 8 characters, one capital letter, and one numeric)
    
}
module.exports = { login, register };

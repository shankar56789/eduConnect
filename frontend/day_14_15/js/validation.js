function login() {
    const username = document.getElementById("loginUsername").value.trim();
    const password = document.getElementById("loginPassword").value.trim();
    const message = document.getElementById("message");

    if (!username || !password) {
        message.innerHTML = "All fields are required";
        return;
    }

    console.log(`Login clicked. Username: ${username}, Password: ${password}`);
    message.innerHTML = "Login attempt successful";
}

function register() {
    const name = document.getElementById("registerName").value.trim();
    const email = document.getElementById("registerEmail").value.trim();
    const username = document.getElementById("registerUsername").value.trim();
    const password = document.getElementById("registerPassword").value.trim();
    const message = document.getElementById("message");

    if (!name || !email || !username || !password) {
        message.innerHTML = "All fields are required";
        return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        message.innerHTML = "Invalid email format";
        return;
    }

    const specialCharacters = /[^a-zA-Z0-9]/.test(username);
    if (specialCharacters) {
        message.innerHTML = "Username cannot contain special characters";
        return;
    }

    const passwordRegex = /(?=.*[A-Z])(?=.*\d)/;
    if (password.length < 8) {
        message.innerHTML = "Password must be at least 8 characters";
        return;
    }
    if (!passwordRegex.test(password)) {
        message.innerHTML = "Password must contain at least one capital letter and one digit";
        return;
    }

    console.log(`Register clicked. Name: ${name}, Email: ${email}, Username: ${username}, Password: ${password}`);
    message.innerHTML = "Successfully Registered";
}

if (typeof module !== 'undefined' && module.exports) {
    module.exports = { login, register };
}

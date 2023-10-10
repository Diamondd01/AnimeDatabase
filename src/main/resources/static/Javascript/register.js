const registerForm = document.getElementById('register-form');
const registerUsername = document.getElementById('register-username');
const registerPassword = document.getElementById('register-password');

const headers = {
    'Content-Type': 'application/json'
};

const baseUrl = 'http://localhost:8080/api/v1/users';

const handleSubmit = async (e) => {
    e.preventDefault();

    const username = registerUsername.value;
    const password = registerPassword.value;

    if (!username || !password) {

        alert('Please enter a username and password.');
        return;
    }

    const bodyObj = {
        username: username,
        password: password
    };

    try {
        const response = await fetch(`${baseUrl}/register`, {
            method: "POST",
            body: JSON.stringify(bodyObj),
            headers: headers
        });

        if (response.ok) {
            const responseArr = await response.json();
            document.cookie = `sessionToken=${responseArr[0]}; path=/`;
            window.location.replace('home.html');
        } else {
            // Handles registration failure and display an error message
            alert('Registration failed. Please try again.');
        }
    } catch (error) {
        console.error('Error:', error);

        alert('An unexpected error occurred.');
    }
};

registerForm.addEventListener("submit", handleSubmit);

function validateForm() {
  document.querySelectorAll(".error").forEach(e => e.innerText = "");

  let isValid = true;
  const firstName = document.getElementById("firstName").value.trim();
  const lastName = document.getElementById("lastName").value.trim();
  const email = document.getElementById("email").value.trim();
  const userId = document.getElementById("userId").value.trim();
  const password = document.getElementById("password").value;
  const confirmPassword = document.getElementById("confirmPassword").value;

  const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;
  if (firstName === "") {
    document.getElementById("firstNameError").innerText = "First name is required.";
    isValid = false;
  }
  if (lastName === "") {
    document.getElementById("lastNameError").innerText = "Last name is required.";
    isValid = false;
  }
  if (email === "") {
    document.getElementById("emailError").innerText = "Email is required.";
    isValid = false;
  } else if (!emailPattern.test(email)) {
    document.getElementById("emailError").innerText = "Enter a valid email address.";
    isValid = false;
  }
  if (userId === "") {
    document.getElementById("userIdError").innerText = "User ID is required.";
    isValid = false;
  }

  if (password === "") {
    document.getElementById("passwordError").innerText = "Password is required.";
    isValid = false;
  }

  if (confirmPassword === "") {
    document.getElementById("confirmPasswordError").innerText = "Please confirm your password.";
    isValid = false;
  } else if (password !== confirmPassword) {
    document.getElementById("confirmPasswordError").innerText = "Passwords do not match.";
    isValid = false;
  }

  return isValid;
}

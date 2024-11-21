// Get the current theme from localStorage
let currentTheme = getTheme();

// Initial setup: Set the theme and add event listeners
document.addEventListener("DOMContentLoaded", () => {
	changeTheme();
})

// Function to initialize the theme and set up the event listener
function changeTheme() {
    // Apply the current theme to the web page
    document.querySelector('html').classList.add(currentTheme);

    // Set up the listener on the change theme button
    const changeThemeButton = document.querySelector("#theme-change-button");
    
    if (changeThemeButton) {
        changeThemeButton.addEventListener("click", (event) => {
            const oldTheme = currentTheme;

            // Toggle between 'dark' and 'light'
            currentTheme = currentTheme === "dark" ? "light" : "dark";

            // Update localStorage with the new theme
            setTheme(currentTheme);

            // Remove the old theme and apply the new theme
            document.querySelector('html').classList.remove(oldTheme);
            document.querySelector('html').classList.add(currentTheme);

            // Update the button text to reflect the current theme
            changeThemeButton.querySelector('span').textContent = currentTheme === "light" ? "Dark" : "Light";
        });

        // Set the initial button text based on the current theme
        changeThemeButton.querySelector('span').textContent = currentTheme === "light" ? "Dark" : "Light";
    } else {
        console.error("Theme change button not found");
    }
}

// Function to save the current theme to localStorage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

// Function to retrieve the theme from localStorage
function getTheme() {
    const theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

// displays favorite characters
const characterResults = document.getElementById('characterResults');
characterResults.innerHTML = ''; // Clear previous results

// fetch and display favorite characters for the signed-in user
async function displayFavoriteCharacters() {
    try {
        // get the signed-in user's information
        const userResponse = await fetch('/api/auth/user');
        if (!userResponse.ok) {
            throw new Error('Failed to fetch user information');
        }
        const userData = await userResponse.json();

        // Use the user's ID from userData to fetch their favorite characters
        const userId = userData.id;
        const response = await fetch(`/api/${userId}/favorites`);
        if (!response.ok) {
            throw new Error('Failed to fetch favorite characters');
        }
        const favoriteCharacters = await response.json();

        if (favoriteCharacters.length === 0) {
            characterResults.innerHTML = 'No favorite characters found.';
        } else {
            favoriteCharacters.forEach((character) => {
                const characterDiv = document.createElement('div');
                characterDiv.innerHTML = `
                    <h2>${character.name}</h2>
                    <p>${character.description}</p>
                    <img src="${character.imageUrl}" alt="${character.name}">
                `;
                characterResults.appendChild(characterDiv);
            });
        }
    } catch (error) {
        console.error(error);
        characterResults.innerHTML = 'An error occurred while fetching favorite characters.';
    }
}


window.addEventListener('load', displayFavoriteCharacters);

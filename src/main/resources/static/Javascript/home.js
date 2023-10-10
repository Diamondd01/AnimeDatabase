document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.getElementById('searchInput');
    const searchButton = document.getElementById('searchButton');
    const searchResults = document.getElementById('searchResults');
    const characterResults = document.getElementById('characterResults'); // Moved characterResults outside of the click event


    function showCustomNotification() {
        const customNotification = document.getElementById('custom-notification');
        customNotification.style.display = 'block';

        setTimeout(() => {
            customNotification.style.display = 'none';
        }, 3000);
    }
    characterResults.addEventListener('click', (event) => {
        const target = event.target;

        if (target.classList.contains('favbtn')) {
            showCustomNotification();
        }
    });
    async function getUserData() {
        try {
            const userResponse = await fetch('http://localhost:8080/api/auth/user');

            if (!userResponse.ok) {
                throw new Error('Failed to fetch user information');
            }

            return userResponse.json();
        } catch (error) {
            console.error(error);
            return null;

            function showAlert() {
                alert('Character added to favorites.');
            }
        }
    }
    characterResults.addEventListener('click', (event) => {
        const target = event.target;

        if (target.classList.contains('favbtn')) {
            showCustomNotification();
        }
    })

    searchButton.addEventListener('click', () => {
        const query = searchInput.value.trim();
        if (query !== '') {
            // Sends API request
            fetch(`http://localhost:8080/api/characters/search?query=${query}`)
                .then((response) => {
                    if (!response.ok) {
                        throw new Error(`HTTP error! Status: ${response.status}`);
                    }
                    return response.json();
                })
                .then((data) => {
                    // Clears the previous search results
                    characterResults.innerHTML = '';

                    if (data.length === 0) {
                        characterResults.innerHTML = 'No results found.';
                    } else {
                        data.forEach((character) => {
                            character.imageUrl = `/CharacterImages/${character.imageUrl}`;
                            const characterDiv = document.createElement('div');
                            characterDiv.innerHTML = `
                        <h2>${character.name}</h2>
                        <p>${character.description}</p>
                         <img src="${character.imageUrl}" alt="${character.name}">
                         <button class="favbtn" data-character-id="${character.id}">Add to favorites</button>
                  `;
                            characterResults.appendChild(characterDiv);
                        });
                    }
                })
                .catch((error) => {
                    console.error('Error:', error);
                    characterResults.innerHTML = 'An error occurred while fetching data.';
                });
        } else {
            alert('Please enter a search query.');
        }
    });
});

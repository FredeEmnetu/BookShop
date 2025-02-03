// Event listener for the search button
document.querySelector('.search-button').addEventListener('click', function () {
    const searchInput = document.getElementById('searchInput').value.trim();
    handleBookFetch(searchInput ? `http://localhost:8080/books?title=${encodeURIComponent(searchInput)}` : `http://localhost:8080/books`, searchInput);
});

// Event listener for the "All Books" nav link
document.querySelector('#allBooksLink').addEventListener('click', function (event) {
    event.preventDefault(); // Prevent default link behavior
    handleBookFetch('http://localhost:8080/All', 'All Books');
}); 

// Function to handle fetching and displaying books
function handleBookFetch(url, query) {
    // Hide the main content and show the search result section
    document.getElementById('main-content').style.display = 'none';
    const searchResultSection = document.getElementById('searchResult');
    searchResultSection.style.display = 'block';

    // Update the search result text
    const searchText = document.getElementById('searchText');
    searchText.textContent = query === 'All Books' ? 'Showing all books:' : `You searched for: "${query}"`;

    // Make a fetch request to get books
    fetch(url)
        .then(async response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            const data = await response.json();

            // Display the blue boxes section
            const Container = document.getElementById('ResultContainer');
            Container.style.display = 'block';

            // Clear previous blue boxes and results
            const Grid = document.getElementById('resultGrid');
            Grid.innerHTML = '';

            // Update search text to "Results"
            searchText.textContent = query === 'All Books' ? 'Results:' : `Results for "${query}":`;

            // Process and display fetched data
            data.forEach(book => {
                const bookElement = document.createElement('div');
                bookElement.classList.add('book');

                const imgElement = document.createElement('img');
                imgElement.src = book.image;
                imgElement.alt = book.title;

                bookElement.appendChild(imgElement);
                Grid.appendChild(bookElement);
            });
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            searchText.textContent = `Error: ${error.message}`;
        });
}

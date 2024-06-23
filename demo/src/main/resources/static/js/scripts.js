document.addEventListener('DOMContentLoaded', (event) => {
    const postList = document.getElementById('postList');
    const loginBtn = document.getElementById('loginBtn');
    const registerBtn = document.getElementById('registerBtn');
    const logoutBtn = document.getElementById('logoutBtn');

    fetch('/api/posts')
        .then(response => response.json())
        .then(data => {
            data.forEach(post => {
                const postItem = document.createElement('div');
                postItem.innerHTML = `<h2>${post.title}</h2><p>${post.content}</p>`;
                postList.appendChild(postItem);
            });
        });

    if (isLoggedIn()) {
        loginBtn.style.display = 'none';
        registerBtn.style.display = 'none';
        logoutBtn.style.display = 'block';
    } else {
        loginBtn.style.display = 'block';
        registerBtn.style.display = 'block';
        logoutBtn.style.display = 'none';
    }
});

function isLoggedIn() {
    // 로그인 상태를 확인하는 로직을 구현
    return localStorage.getItem('loggedIn') === 'true';
}

document.addEventListener('DOMContentLoaded', function() {
    // Add any JavaScript here for future enhancements or interactivity
});

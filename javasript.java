
function updateProgressBar() {
    var progressBar = document.getElementById('loading-bar');
    var loadingText = document.getElementById('loading-text');

    function getRandomNumber() {
        return Math.floor(Math.random() * 20) + 1;
    }

    var progress = 0;
    var interval = setInterval(function () {
        progress += getRandomNumber();
        progress = Math.min(progress, 100);
        progressBar.style.width = progress + '%';
        loadingText.textContent = progress + '%';

        // Change color based on percentage
        if (progress <= 30) {
            progressBar.style.background = 'linear-gradient(to right, #ffee00, #ff9500)';
        } else if (progress <= 60) {
            progressBar.style.background = 'linear-gradient(to right, #ffee00, #ff9500)';
        } else if (progress <= 80) {
            progressBar.style.background = 'linear-gradient(to right, #ffee00, #ff9500)';
        } else {
            progressBar.style.background = 'linear-gradient(to right, #ffee00, #ff9500)';
        }

        if (progress >= 100) {
            clearInterval(interval);
            document.getElementById('loading-screen').style.display = 'none';
        }
    }, 700);
}

updateProgressBar();
    // Real-time clock :)
    function updateClock() {
        const now = new Date();
        const hours = now.getHours().toString().padStart(2, '0');
        const minutes = now.getMinutes().toString().padStart(2, '0');

        const timeString = `${hours}.${minutes}`;

        document.getElementById('clock').textContent = timeString;
    }

    // Panggil fungsi updateClock setiap detik
    setInterval(updateClock, 1000);

    // Panggil untuk pertama kali saat halaman dimuat
    updateClock();

    function updateDate() {
        const now = new Date();
        const dayNames = ['Senin', 'Selasa', 'Rabu', 'Kamis', 'Jumat', 'Sabtu', 'Minggu'];
        const monthNames = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        const day = dayNames[now.getDay()];
        const date = now.getDate().toString().padStart(2, '0');
        const month = monthNames[now.getMonth()];
        const year = now.getFullYear();

        const dateString = `${day}, ${date} ${month} ${year}`;

        document.getElementById('date').textContent = dateString;
    }

    // Panggil fungsi updateDate setiap detik
    setInterval(updateDate, 1000);

    // Panggil untuk pertama kali saat halaman dimuat
    updateDate();
// Assasistive Touch //
const assistiveTouch = document.getElementById('assistiveTouch');
    const body = document.body;

    // Fungsi untuk menangani klik pada ikon
    function handleIconClick() {
        // Toggle warna latar belakang antara putih dan hitam
        body.style.backgroundColor = (body.style.backgroundColor === 'white') ? 'black' : 'white';
        
        // Toggle warna ikon antara hitam dan putih
        const isBlackBackground = body.style.backgroundColor === 'white';
        assistiveTouch.style.backgroundColor = isBlackBackground ? 'white' : 'white';
        assistiveTouch.style.color = isBlackBackground ? 'white' : 'white';
    }

    // Fungsi untuk mengaktifkan pergerakan ikon
    function enableDrag() {
        let offsetX, offsetY;

        function dragStart(e) {
            offsetX = e.clientX - assistiveTouch.getBoundingClientRect().left;
            offsetY = e.clientY - assistiveTouch.getBoundingClientRect().top;

            document.addEventListener('mousemove', dragMove);
            document.addEventListener('mouseup', dragEnd);
        }

        function dragMove(e) {
            const x = e.clientX - offsetX;
            const y = e.clientY - offsetY;

            assistiveTouch.style.left = `${x}px`;
            assistiveTouch.style.top = `${y}px`;
        }

        function dragEnd() {
            document.removeEventListener('mousemove', dragMove);
            document.removeEventListener('mouseup', dragEnd);
        }

        assistiveTouch.addEventListener('mousedown', dragStart);
    }

    assistiveTouch.addEventListener('click', handleIconClick);
    enableDrag();

    // Pergerakan ikon android
    // Rest of your code...

// Function to enable touch-based dragging
function enableTouchDrag() {
let offsetX, offsetY;

function touchStart(e) {
    offsetX = e.touches[0].clientX - assistiveTouch.getBoundingClientRect().left;
    offsetY = e.touches[0].clientY - assistiveTouch.getBoundingClientRect().top;

    document.addEventListener('touchmove', touchMove, { passive: false });
    document.addEventListener('touchend', touchEnd);
}

function touchMove(e) {
    const x = e.touches[0].clientX - offsetX;
    const y = e.touches[0].clientY - offsetY;

    assistiveTouch.style.left = `${x}px`;
    assistiveTouch.style.top = `${y}px`;

    // Prevent default scrolling behavior on touch devices
    e.preventDefault();
}

function touchEnd() {
    document.removeEventListener('touchmove', touchMove);
    document.removeEventListener('touchend', touchEnd);
}

assistiveTouch.addEventListener('touchstart', touchStart);
}

// Call the enableTouchDrag function to enable touch-based dragging
enableTouchDrag();

           // Variable to track the flashlight state (on/off)
           var isFlashlightOn = false;

                   // Event listener for flashlight element
    document.getElementById('flashlight').addEventListener('click', function() {
        // Toggle the flashlight state
        var flashlightElement = document.getElementById('flashlight');
        flashlightElement.classList.add('light-on');

        // Set timeout to remove the light effect after 2 seconds
        setTimeout(function() {
            flashlightElement.classList.remove('light-on');
        }, 2000);
        //App on center notification
    });
        // Fungsi untuk mengganti latar belakang secara otomatis setiap 10 detik
function autoChangeWallpaper() {
    setInterval(function() {
        const wallpaperElement = document.getElementById('screen');
        const currentWallpaper = wallpaperElement.style.backgroundImage;
        
        // Simpan URL wallpaper yang sedang ditampilkan saat ini
        const currentWallpaperUrl = currentWallpaper.slice(5, -2);

        // Daftar URL wallpaper yang tersedia
        const wallpaperUrls = [
            'https://i.ibb.co/XWXkj1r/wallpaper3.png',
            'https://i.ibb.co/nm9YmNS/wallpaper2.png',
            'https://i.ibb.co/1GNRhB1/wallpaper2.png',
            'https://i.ibb.co/mtzd1Cr/peakpx-1.jpg'
        ];

        // Cari indeks wallpaper saat ini dalam daftar
        const currentIndex = wallpaperUrls.indexOf(currentWallpaperUrl);

        // Hitung indeks berikutnya dengan menghindari nilai di luar batas array
        const nextIndex = (currentIndex + 1) % wallpaperUrls.length;

        // Ganti latar belakang dengan wallpaper berikutnya
        wallpaperElement.style.backgroundImage = `url(${wallpaperUrls[nextIndex]})`;
    }, 8000); // 10 detik (dalam milidetik)
}

// Panggil fungsi autoChangeWallpaper untuk memulai perubahan otomatis
autoChangeWallpaper();

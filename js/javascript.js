// 1. JS Basics & Setup
console.log("Welcome to the Community Portal");
window.onload = () => alert("Page fully loaded!");

// 2. Data Types, Operators
const eventName = "Music Night";
const eventDate = "2025-06-01";
let seats = 5;
console.log(`${eventName} is on ${eventDate} with ${seats} seats.`);

// 3. Conditionals, Loops
const events = [
  { id: 1, name: "Music Night", date: "2025-06-01", category: "Music", seats: 5 },
  { id: 2, name: "Baking Workshop", date: "2025-04-01", category: "Workshop", seats: 0 },
  { id: 3, name: "Community Soccer", date: "2025-07-15", category: "Sports", seats: 10 }
];

const upcomingEvents = events.filter(event => {
  const isUpcoming = new Date(event.date) > new Date();
  const hasSeats = event.seats > 0;
  return isUpcoming && hasSeats;
});

function displayEvents(list) {
  const container = document.getElementById('eventsContainer');
  container.innerHTML = "";
  list.forEach(event => {
    const card = document.createElement('div');
    card.innerHTML = `
      <h3>${event.name}</h3>
      <p>${event.date} - ${event.category}</p>
      <p>Seats left: ${event.seats}</p>
      <button onclick="registerUser(${event.id})">Register</button>
    `;
    container.appendChild(card);
  });
}
displayEvents(upcomingEvents);

// 4. Functions, Closures
function addEvent(newEvent) {
  events.push(newEvent);
}

function registerUser(eventId) {
  try {
    const event = events.find(e => e.id === eventId);
    if (!event || event.seats <= 0) throw "Event full or not found";
    event.seats--;
    alert(`Registered for ${event.name}`);
    displayEvents(upcomingEvents);
    populateEventSelect(); // Update dropdown
  } catch (err) {
    alert("Error: " + err);
  }
}

function filterEventsByCategory(category) {
  return category === "All"
    ? upcomingEvents
    : upcomingEvents.filter(e => e.category === category);
}

// 5. Objects and Prototypes
function Event(name, date, category, seats) {
  this.name = name;
  this.date = date;
  this.category = category;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

// 6. Array Methods
const musicEvents = events.filter(e => e.category === "Music");
const titles = events.map(e => `${e.category}: ${e.name}`);

// 7. DOM Manipulation
function populateEventSelect() {
  const select = document.getElementById('eventSelect');
  select.innerHTML = "";
  upcomingEvents.forEach(e => {
    const option = document.createElement('option');
    option.value = e.id;
    option.textContent = e.name;
    select.appendChild(option);
  });
}
populateEventSelect();

// 8. Event Handling
document.getElementById("categoryFilter").onchange = (e) => {
  const filtered = filterEventsByCategory(e.target.value);
  displayEvents(filtered);
};

document.getElementById("searchInput").addEventListener("keydown", (e) => {
  const query = e.target.value.toLowerCase();
  const filtered = upcomingEvents.filter(ev => ev.name.toLowerCase().includes(query));
  displayEvents(filtered);
});

// 9. Async JS
async function fetchMockEvents() {
  document.getElementById('eventsContainer').innerHTML = "Loading...";
  try {
    const response = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await response.json();
    console.log("Fetched mock data:", data.slice(0, 3));
  } catch (err) {
    console.error("Fetch failed", err);
  }
}
fetchMockEvents();

// 10. Modern JS
function logEvent({ name, date }) {
  console.log(`Event: ${name}, Date: ${date}`);
}
const [firstEvent] = upcomingEvents;
logEvent(firstEvent);

const clonedEvents = [...upcomingEvents];

// 11. Forms
document.getElementById('registrationForm').addEventListener('submit', function (e) {
  e.preventDefault();
  const { name, email, eventSelect } = e.target.elements;
  if (!name.value || !email.value) {
    alert("All fields are required!");
    return;
  }
  console.log("Form Submitted:", name.value, email.value, eventSelect.value);
});

// 12. AJAX + Fetch
function simulatePostRegistration(data) {
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" },
  })
    .then(res => res.json())
    .then(json => {
      console.log("POST response:", json);
      setTimeout(() => alert("Registration successful!"), 1000);
    })
    .catch(err => alert("Failed to submit registration."));
}

// 13. Debugging: Add breakpoints via DevTools
console.log("Debug: Registration system is active.");

// 14. jQuery (Add jQuery in HTML first for this to work)
/*
$(document).ready(function () {
  $('#registerBtn').click(() => alert("Registered with jQuery!"));
  $('.event-card').fadeIn();
});
*/

// Benefit of JS Frameworks: React/Vue allow reusable UI components, faster DOM updates, and state management.





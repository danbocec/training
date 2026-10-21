// Search for a client

async function getOneClient() {
  const clientName = document.getElementById("client-search").value;

  try {
    const response = await fetch(`/client/${encodeURIComponent(clientName)}`);

    if (!response.ok) {
      throw new Error("Couldn't retrieve client");
    }
    const client = await response.json();
    const clientResult = document.getElementById("client-result");

    const listItem = document.createElement("li");
    listItem.textContent = `Name: ${client.name}, Age: ${client.age}, Email: ${client.email}, Phone Number: ${client.phoneNumber}, Address: ${client.address}, Membership Type: ${client.membershipType}`;

    clientResult.replaceChildren(listItem);
  } catch (error) {
    console.error("Couldn't retrieve client", error);
  }
}

document
  .getElementById("fetch-client-btn")
  .addEventListener("click", getOneClient);

// Get clients from the server
async function getClients() {
  const clients = await fetch("client/clients");
  if (!clients.ok) {
    throw new Error("Failed to fetch clients");
  }
  const clientsData = await clients.json();
  return clientsData;
}

// Fetch clients from function getClients
function fetchClientsBtn() {
  const clientButton = document.getElementById("fetchClientsBtn");

  clientButton.addEventListener("click", async function () {
    const clients = await getClients();
    const clientList = document.getElementById("client-list");

    clientList.innerHTML = ""; // Clear the list before adding new items

    for (const client of clients) {
      const listItem = document.createElement("li");
      listItem.textContent = `Name: ${client.name}, Age: ${client.age}, Email: ${client.email}, Phone Number: ${client.phoneNumber}, Address: ${client.address}, Membership Type: ${client.membershipType}`;
      clientList.appendChild(listItem);
    }
  });
}

// Post new Clients onto the API
async function postNewClients(event) {
  event.preventDefault();

  const clientData = {
    name: document.getElementById("name").value,
    age: Number(document.getElementById("age").value),
    email: document.getElementById("email").value,
    phoneNumber: document.getElementById("phoneNumber").value,
    address: document.getElementById("address").value,
    membershipType: document.getElementById("membershipType").value,
  };

  try {
    const response = await fetch("client/postClient", {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(clientData),
    });

    if (response == 409) {
      console.error("There is a client registred with this name or/ email! ");
    }
    if (!response.ok) {
      throw new Error("Failed to create client");
    }
  } catch (error) {
    console.error("Couldnt register client", error);
  }
}

document
  .getElementById("clientForm")
  .addEventListener("submit", postNewClients);

fetchClientsBtn();

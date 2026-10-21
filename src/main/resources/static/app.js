// Get clients from the server
async function getClients() {
  const clients = await fetch("client/clients");
  if (!clients.ok) {
    throw new Error("Failed to fetch clients");
  }
  const clientsData = await clients.json();
  console.log(clientsData);
  return clientsData;
}

function fetchClientsBtn() {
  const clientButton = document.getElementById("fetchClientsBtn");

  clientButton.addEventListener("click", function () {
    getClients();
  });
}
fetchClientsBtn();

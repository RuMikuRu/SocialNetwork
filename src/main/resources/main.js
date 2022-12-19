let request;
let action;
async function makeRequestAll(event) {
  if (request != undefined) {
    //console.log(event.currentTarget.id);
    const response = await fetch(`http://localhost:8080/${request}/all`);
    const json = await response.json();
    textarea.innerText = JSON.stringify(json);
  }
}

const main = document.querySelector("#main");

const valueSelect = document.getElementById("select");

const actionSelect = document.getElementById("actionSelect");

function onChangeAction() {
  let value = actionSelect.value;
  console.log(value);
  action = value;
}

actionSelect.onchange = onChangeAction;

console.log(action);

function onChangeValue() {
  let value = valueSelect.value;
  //console.log(value);
  request = value;
}

valueSelect.onchange = onChangeValue;

//console.log("q=", q);

const button = document.createElement("button");
button.onclick = makeRequestAll;
button.innerText = "Запрос";
button.id = "bt";
main.appendChild(button);

const textarea = document.createElement("p");
textarea.classList = "red bord";
main.appendChild(textarea);

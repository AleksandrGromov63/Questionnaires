function add() {
    let nameOfIssue = document.createElement('input')
    nameOfIssue.setAttribute('type', 'text')

    let btnAddAnswer = document.createElement('button')
    btnAddAnswer.innerText = 'Добавить ответ'

    let body = document.querySelector('body')

    body.appendChild(nameOfIssue)
    body.appendChild(btnAddAnswer)
}
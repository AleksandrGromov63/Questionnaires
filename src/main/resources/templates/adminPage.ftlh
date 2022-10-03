<#import "common.ftlh" as c>
<@c.page>
    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home"
                    type="button" role="tab" aria-controls="pills-home" aria-selected="true">Home
            </button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-create-tab" data-bs-toggle="pill" data-bs-target="#pills-create"
                    type="button" role="tab" aria-controls="pills-create" aria-selected="false">Create
            </button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-edit-tab" data-bs-toggle="pill" data-bs-target="#pills-edit"
                    type="button" role="tab" aria-controls="pills-edit" aria-selected="false">Edit
            </button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-take-the-survey-tab" data-bs-toggle="pill"
                    data-bs-target="#pills-take-the-survey"
                    type="button" role="tab" aria-controls="pills-take-the-survey" aria-selected="false">Take the survey
            </button>
        </li>
        <li class="nav-item" role="presentation">
            <a href="/logout">
                <button class="nav-link" id="logout-tab" data-bs-toggle="pill"
                        type="button" role="tab" aria-selected="false">Logout
                </button>
            </a>
        </li>
    </ul>
    <div class="tab-content" id="pills-tabContent">
        <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab"
             tabindex="0">
            <h2>User responses:</h2>
            <#list allUsers as user>
                <h3>${user.username}</h3>
            </#list>
            <h3>Questionnaires:</h3>
            <#list allQuestionnaires as ques>
                <h3>${ques.name}</h3>
                <h4>Issues:</h4>
                <#list ques.issues as issues>
                    <h4>${issues.name}</h4>
                </#list>
            </#list>
        </div>
        <div class="tab-pane fade" id="pills-create" role="tabpanel" aria-labelledby="pills-create-tab" tabindex="0">
            <div class="create-questionnaire">
                <a href="/admin">
                    <button class="btn-primary">Home</button>
                </a>
                <form action="/admin/constructor" method="post">
                    <div class="input-group input-group-lg">
                        <label for="questionnaireName" class="form-label">Name of the questionnaire</label>
                        <input class="form-control form-control-lg" type="text" name="questionnaireName"
                               id="questionnaireName">
                    </div>
                    <button class="btn-primary" id="add-question" type="button">Add question</button>
                    <div class="questions"></div>
                    <input type="hidden" id="gold" name="mapWrapper">
                    <input type="submit" name="Save" class="btn-primary" onclick="fnc()">
                </form>
            </div>
            <script>
                const questions = document.querySelector('.questions')
                const form = document.querySelector('form')
                const addQuestionBtn = document.querySelector('#add-question')

                const questionsMap = new Map([[String.prototype, [String.prototype]]])
                questionsMap.set('Country1', ['State1', 'State2'])
                questionsMap.set('Country2', ['State1', 'State2', 'State3'])

                let answersCount = 0
                const asdfd = 'ferrum'
                function fnc() {
                  /*  const map = document.getElementById('gold')
                    map.value = questionsMap*/
                    $.ajax({
                        type : 'POST',
                        url : 'http://localhost:8080/admin/constructor',
                        data : asdfd,
                        contentType : "application/json; charset=utf-8",
                        dataType : "json"
                    })
                }

                addQuestionBtn.addEventListener('click', () => {
                    const questionWrapper = document.createElement('div')

                    questionWrapper.classList.add('question-wrapper')

                    questions.appendChild(questionWrapper)

                    const d = createQuestion(questionWrapper)
                });

                const getQuestionsCount = () => {
                    return document.querySelectorAll('.question-wrapper').length;
                };

                const createQuestion = (questionWrapper) => {
                    const wrapper = document.createElement('div')
                    const inputQuestion = document.createElement('input')
                    const inputAnswerOne = document.createElement('input')
                    const inputAnswerTwo = document.createElement('input')
                    const deleteBtn = document.createElement('button')
                    const addAnswerBtn = document.createElement('button');

                    wrapper.classList.add('input-group', 'mb-3')

                    const questionsCount = getQuestionsCount()

                    inputQuestion.classList.add('form-control')
                    inputQuestion.id = questionsCount.toString()
                    inputQuestion.type = 'text'
                    inputQuestion.placeholder = 'Question'


                    inputAnswerOne.classList.add('form-control')
                    inputAnswerOne.classList.add('nameAnswer' + answersCount)
                    inputAnswerOne.type = 'text'
                    inputAnswerOne.placeholder = 'Answer'


                    inputAnswerTwo.classList.add('form-control')
                    inputAnswerTwo.classList.add('nameAnswer' + answersCount)
                    inputAnswerTwo.type = 'text'
                    inputAnswerTwo.placeholder = 'Answer'


                    deleteBtn.type = 'btn-close'
                    deleteBtn.innerText = 'delete'

                    addAnswerBtn.type = 'btn-check'
                    addAnswerBtn.innerText = 'Add answer'

                    wrapper.appendChild(inputQuestion)
                    wrapper.appendChild(inputAnswerOne)
                    wrapper.appendChild(inputAnswerTwo)
                    wrapper.appendChild(deleteBtn)
                    wrapper.appendChild(addAnswerBtn)

                    deleteBtn.addEventListener('click', () => {

                        if (wrapper.querySelectorAll('.question').length === 1) {
                            questionWrapper.remove();
                            return;
                        }

                        wrapper.remove();
                    })

                    questionWrapper.appendChild(wrapper)

                    const question = document.getElementById(questionsCount.toString())
                    const allAnswers = document.getElementsByClassName('nameAnswer' + answersCount)
                    let list = []
                    for (let allAnswersKey in allAnswers) {
                        list.push(allAnswersKey.value.toString())
                    }
                    questionsMap.set(question.value, list)

                    answersCount++
                    return questionsCount;
                }
            </script>
        </div>
        <div class="tab-pane fade" id="pills-edit" role="tabpanel" aria-labelledby="pills-edit-tab" tabindex="0">
            ..C.
        </div>
        <div class="tab-pane fade" id="pills-take-the-survey" role="tabpanel"
             aria-labelledby="pills-take-the-survey-tab"
             tabindex="0">..D.
        </div>
    </div>
<#--   <script>
       const triggerTabList = document.querySelectorAll('#pills-profile-tab')
       triggerTabList.forEach(triggerEl => {
           const tabTrigger = new bootstrap.Tab(triggerEl)

           triggerEl.addEventListener('click', event => {
               event.preventDefault()
               tabTrigger.show()
           })
       })
   </script>-->
</@c.page>
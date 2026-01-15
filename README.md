POST - http://localhost:8080/api/quiz/question

{
  "question": "React is a ___?",
  "optionA": "Framework",
  "optionB": "Library",
  "optionC": "Language",
  "optionD": "Database",
  "correctOption": "B"
}

GET - http://localhost:8080/api/quiz/questions

input: 
{
  "answers": {
    "1": "B"
  }
}

output:
{
  "score": 1,
  "total": 1
}

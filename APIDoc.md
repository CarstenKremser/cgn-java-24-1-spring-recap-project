#API Documentation

## Endpoints

GET /api/todo

GET /api/todo/{id}

PUT /api/todo

Body (JSON):
{
    id: IDENTIFIER (integer)
    description: TODONAME (String)
    status: STATUS (Enum)
}

mögliche STATUS-WERTE:
* OPEN (open)
* IN_PROGRESS (doing)
* DONE (done)

GET /details/undefined

GET /edit/undefined



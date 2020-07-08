# Give4Free
Projet de fin d'année avec mon groupe(Front-end), Solution SaaS de financement participatif, Back-end Java Spring Boot


    
On peut crée une annonces avec cet appel (Post) http://localhost:8080/annonces/

header: "Content-Type" : "application/json"

"Authorization": "token"

body: {


"title":"mehdi.rhoulam@epitech.eu",
"description":"[\"hello_world\", \"test\"]",
"date_debut":"2000-01-01T09:00:00.000Z",
"date_fin":"2020-07-07T09:00:00.000Z",
"image":"test", //foutez moi un base64 man google
"userId":"r7mrFUkUomE4aHJxiCcEfbGvIxVTHy"


}


on peut récup une annonce par cet appel

annonces/{annonceid}


header: "Content-Type" : "application/json"

"Authorization": "token"
body null

allez bougez vot kul

(1 mentions J'aime)

(appelle Delete) 


annonces/{annonceid}

header: "Content-Type" : "application/json"
"Authorization": "token"
body null
 

(appelle Put)
 annonces/{annonceid}



header: "Content-Type" : "application/json"
"Authorization": "token"
body: {


    "title": "newtitile",
    "description": "[\"string1\", \"neewstring2\"]",
    "date_debut": "2001-11-11T09:00:00.000Z",
    "date_fin": "2001-11-11T09:00:00.000Z",
    "image": "IMAGE", //foutez moi un base64 man google
    "userId": "r7mrFUkUomE4aHJxiCcEfbGvIxVTHy" //normalement vous garder le même userid...

}

gestion utilisateur

{
	"info": {
		"_postman_id": "3a78db6a-c78e-4365-b257-cf606cd01568",
		"name": "YEAR-END PROJECT 2020 GIVE4FREE",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Create user",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"email\": \"ifdbgjhbfgmehdi.rhoulam@epitech.eu\",\r\n    \"password\": \"Xdveg567\",\r\n    \"firstName\": \"Jean\",\r\n    \"lastName\": \"DU CUL\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/users",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users"
					]
				}
			},
			"response": []
		},
		{
			"name": "Login",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "Accept",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"email\": \"ifdbgjhbfgmehdi.rhoulam@epitech.eu\",\r\n    \"password\": \"Xdveg567\"\r\n}"
				},
				"url": {
					"raw": "http://localhost:8080/users/login",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users",
						"login"
					]
				}
			},
			"response": []
		},
		{
			"name": "Delete user",
			"request": {
				"method": "DELETE",
				"header": [
					{
						"key": "Authorization",
						"type": "text",
						"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpZmRiZ2poYmZnbWVoZGkucmhvdWxhbUBlcGl0ZWNoLmV1IiwiZXhwIjoxNTkzMTYzMjIzfQ.sxK3cIK1RYxjlDL_kpa4g9Oy0yrZIJVJxg1g4cCNPyysZb03gukIc8EA_Lo8LThE-u2WzRf3eSJc9sWY5A6R8g"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/users/aPb3x5Bz4WWBA3sCv9APXHoqZaA2PY",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users",
						"aPb3x5Bz4WWBA3sCv9APXHoqZaA2PY"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get userInfo",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpZmRiZ2poYmZnbWVoZGkucmhvdWxhbUBlcGl0ZWNoLmV1IiwiZXhwIjoxNTkzMTYzMjIzfQ.sxK3cIK1RYxjlDL_kpa4g9Oy0yrZIJVJxg1g4cCNPyysZb03gukIc8EA_Lo8LThE-u2WzRf3eSJc9sWY5A6R8g",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"email\": \"mehdi.rhoulam0@epitech.eu\",\r\n    \"password\": \"Xdveg567\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/users/aPb3x5Bz4WWBA3sCv9APXHoqZaA2PY",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users",
						"aPb3x5Bz4WWBA3sCv9APXHoqZaA2PY"
					]
				}
			},
			"response": []
		}
	],
	"protocolProfileBehavior": {}
}
(Collection Postman)

Ceci n'est qu'une version "alpha"...

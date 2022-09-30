# i-Lab Kotlin App
# Demo:


![1](https://user-images.githubusercontent.com/46970213/145789679-e9168763-f409-4177-b48d-3e9211698fbb.JPG)
![2](https://user-images.githubusercontent.com/46970213/145789684-c5199d58-0685-4257-96fc-3da98f573a4f.JPG)
![3](https://user-images.githubusercontent.com/46970213/145789686-7590ba05-6493-4562-a1ff-a043b7557f87.JPG)
![4](https://user-images.githubusercontent.com/46970213/145789689-ae46a767-753b-4c8d-b125-6d17f3f4da93.JPG)
![5](https://user-images.githubusercontent.com/46970213/145789692-398a04e2-3974-4dd7-a63a-19d33a88b3a5.JPG)
![6](https://user-images.githubusercontent.com/46970213/145789695-2979e40e-f022-4528-9b51-ac29c20e5419.JPG)
![7](https://user-images.githubusercontent.com/46970213/145789699-f495957d-c017-45ed-ae7a-763e5814be46.JPG)
![8](https://user-images.githubusercontent.com/46970213/145789703-5dbb013c-f5a1-4221-8975-30124615d616.JPG)
![9](https://user-images.githubusercontent.com/46970213/145789705-afc3b998-a2fd-4d0f-be44-1288810dd51f.JPG)
![10](https://user-images.githubusercontent.com/46970213/145789708-a54dd52e-cd3d-4f3f-8554-74cd6b88f6fa.JPG)
![11](https://user-images.githubusercontent.com/46970213/145789649-76fd5a8b-113d-445d-aacf-49a1bb7c4752.JPG)
![12](https://user-images.githubusercontent.com/46970213/145789653-703c5f2b-95f3-47c9-bc32-1151d74f0207.JPG)
![13](https://user-images.githubusercontent.com/46970213/145789655-9337dae0-755d-4481-9478-0a5c7daad7d1.JPG)
![14](https://user-images.githubusercontent.com/46970213/145789657-1e17b4a5-bf85-49f2-8c9d-664129f08c7a.JPG)
![15](https://user-images.githubusercontent.com/46970213/145789658-662feaea-6932-4da8-add9-60d9a6dda89e.JPG)
![16](https://user-images.githubusercontent.com/46970213/145789661-ed397d03-4e65-48a2-bf4f-abaf8d66e1db.JPG)
![17](https://user-images.githubusercontent.com/46970213/145789665-8647cee9-1715-40c0-a969-3d0316c07fc9.JPG)
![18](https://user-images.githubusercontent.com/46970213/145789667-20762976-cdab-4e8b-a4de-423ca2e74aeb.JPG)
![19](https://user-images.githubusercontent.com/46970213/145789670-fdad37ca-e948-4e03-bfd7-72390853384a.JPG)

# Requettes Server:

# USER
{
******************************************************** Afficher List Users
http://localhost:3000/api/authentification/show	        [GET]



}






# CHAISE
{
******************************************************** AjoutChaise:
http://localhost:3000/api/chaise/store    [POST]

 {
	  "num_chaise":1,
    "disponibilite": true
	 
 }

******************************************************Afficher Chaises
http://localhost:3000/api/seance/          [GET]







*********************************************************
}





# SEANCE
{
************************************************** AjoutSeance: 
http://localhost:3000/api/seance/store    [POST]

 {
	  "num_seance":10000,
    "date_seance": "23-12-2021",
    "heure_debut": "11:30",
    "heure_fin": "13:30",
    "duree":1,
	  "chaises": [
			{
			"chaise":"61acfa0b893936066c407432",
			"disponibility":false
			}
		]
	 
 }
		 
******************************************************Afficher toutes les seances:
http://localhost:3000/api/seance/          [GET]	


***********************	******************************Afficher les chaises d'un seance AVEC IDSEANCE	 **


http://localhost:3000/api/seance/showw/idseance  [GET]


********************************************************Afficher les chaises d'un seance AVEC IDSEANCE

http://localhost:3000/api/seance/show   POST
{
	  "seanceID":"61ae09dd62ae628da4adf2e1"
	 
 }

********************************************************UPDATE Seat Statut celon idSeance,idSeat  *****
http://localhost:3000/api/seance/updatee/61b62febb1771a2e0897119c/61acfa0b893936066c407432  [GET]
											idSeance              idChaise_1

***************************************************************
***************************************************************
}





# MATERIALS
{
****************************************************AJOUT MATERIELS
http://localhost:3000/api/materiel/store  [POST]

{
	     "type":"iphone",
       "nom_materiel":"iphone7",
       "date_dispo":"2021-12-12",
        "heure_debut":"11:30",
        "heure_fin":"12:30",
        "duree":"1",
        "image":"iphone.png",
        "disponibilite":true
}
	
****************************************************UPDATE MATERIELS
http://localhost:3000/api/materiel/update   [POST]

{
		 	"materielID":"61b411417df8771a32185026",
	     "type":"iphone",
       "nom_materiel":"iphone 6",
       "date_dispo":"2021-12-12",
        "heure_debut":"11:30",
        "heure_fin":"12:30",
        "duree":"1",
        "image":"iphone.png",
        "disponibilite":true
}

****************************************************UPDATE MATERIELS STATUE
http://localhost:3000/api/materiel/updatee/MatID    [GET]



****************************************************AFFICHAGE
http://localhost:3000/api/materiel/           [GET]
}





# PASSAGECLE
{
************************************************** AjoutPassageCle: 
http://localhost:3000/api/passagecle/store   [POST]

  {
	  "newemail":"mail2@esprit.tn",
    "date_passage": "23-12-2021",
	  "userdatas": [
			"61a3cdba5697b6190c1c4ca4"
		]
	 
 }
		 
******************************************************
}


NOTIFIER_DELAI
{
http://localhost:3000/api/notifdelai/store  [POST]

 {
    "Datenotif": "23-12-2021",
	 "delai":"1:30",
	  "userdatas": [
			"61a3cdba5697b6190c1c4ca4"
		]
	 
 }
*******************************************************

}





# Reservation Materials
{
	
*****************************************************************AFFICHER TOUS LES Reservation Materiels:

http://localhost:3000/api/reservermateriel      [GET]

*****************************************************************AJOUT Reservation Materiel:
http://localhost:3000/api/reservermateriel/store  [POST]

 	{
		"datereservationmateriel": "24-12-2021",
		"userdatas": [
			{
				"_id": "61a5fcc0fbd60f723d8a8e48"
				
			}
		],
		"materieldata": [
			{
				"_id": "61aecee8d158f871ad637a19"
			}
		]
		
	}
	
	
*****************************************************************AJOUT Reservationv Materiel:*****
	http://localhost:3000/api/reservermateriel/storee/24122021/61a5fcc0fbd60f723d8a8e48/61aecee8d158f871ad637a19 [GET]

*******************************************************

}




# Reservation Seance
{
http://localhost:3000/api/reserverchaise/store  [POST]

 
	{
		"datereservationchaise": "24-12-2021",
		"seance": [
			{
				"_id": "61ad1a0004f109c5189edf88"
				
			}
		],
		"user": [
			{
				"_id": "61a5fcc0fbd60f723d8a8e48"
			}
		]
		
	}


*******************************************************

}

import random
from math import exp

maxXp = 20

print("")

pxp = int(input("Your initial XP = "))
php = float(input("Your initial HP = "))
pw = [0.5, 10]

print("Your max weapon strength: "+str(pw[1])+" and its precision: "+str(pw[0]))
print("")

enxp = pxp + random.randint(0,3)
ehp = php - random.randint(0,3)

print ("Your enemies XP: "+str(enxp)+" and HP: "+str(int(ehp)))

ew = [random.random(), pw[1]-random.randint(0,3)]
print ("Your enemies max weapon strength: "+str(ew[1])+" and precision: "+str(ew[0]))
fcounter = 1

print("")
print("")

while(php > 0 and pxp < maxXp):

	tmpEHp = ehp
	tmpPHp = php
	
	print("Figth "+str(fcounter))
	fcounter += 1
	print("Your current XP: "+str(pxp)+" and HP: "+str(php))

	rcounter = 1

	while(tmpPHp > 0 and tmpEHp > 0):

		print("Trun "+str(rcounter))
		
		
		pHit = (random.random()*pw[0] + (1/(exp((maxXp - pxp)*random.random())* (1-pw[0]) )) *  pw[0])*pw[1]
		eHit = (random.random()*ew[0] + (1/(exp((maxXp - enxp)*random.random())* (1-ew[0]) )) *  pw[0])*ew[1]

		print("Your strike dealt "+str(pHit)+" damage-points")
		print("Your enemy hit you with "+str(eHit)+" damage")
		print("")

		tmpEHp -= pHit
		tmpPHp -= eHit
		rcounter += 1
		s = raw_input("")

	if(tmpPHp <= 0):
		php = 0
		break;
	else:
		print("Your ripped that guy!")


	php -= random.random()
	pxp += 1
	s = raw_input("next fight? ")
	print("")
	print("")

if(php <= 0):
	print("You died")

else:
	print("You win")

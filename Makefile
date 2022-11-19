Compile: Liking 
	javac App.java
Liking: Packages
	javac -d . ./entidades/*.java ./controle/*.java ./fronteira/*.java
Packages: 
	javac ./entidades/*.java ./controle/*.java ./fronteira/*.java

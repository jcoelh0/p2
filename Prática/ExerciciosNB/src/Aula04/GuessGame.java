package Aula04;

class GuessGame {

    private int minimo, maximo, n, numAttempts = 0;
    int secretNumber;

    public GuessGame(int min, int max) {
	minimo = min;
	maximo = max;
	secretNumber = min + (int) (Math.random() * (double) (max + 1 - min));
    }

    public int min() {
	return minimo;
    }

    public int max() {
	return maximo;
    }

    public boolean validAttempt(int numero) {
	if (numero >= minimo && numero <= maximo) {
	    return true;
	} else {
	    return false;
	}
    }

    public boolean finished() {
	if (n == secretNumber) {
	    return true;
	} else {
	    return false;
	}
    }

    public void play(int n) {
	if(validAttempt(n)){
	    this.n = n;
	    numAttempts++;
	}
    }

    public boolean attemptIsHigher() {
	if (n < secretNumber) {
	    return false;
	} else {
	    return true;
	}
    }

    public boolean attemptIsLower() {
	if (n > secretNumber) {
	    return false;
	} else {
	    return true;
	}
    }

    public int numAttempts() {
	return numAttempts;
    }
}

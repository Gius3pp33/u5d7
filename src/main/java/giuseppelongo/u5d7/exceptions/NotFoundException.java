package giuseppelongo.u5d7.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("L'id " + id + " non è stato trovato");
    }
};



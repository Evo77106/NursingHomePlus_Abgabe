package datastorage;

/**
 * Tha Dao factory
 */
public class DAOFactory {

    private static DAOFactory instance;

    /**
     * .
     */
    private DAOFactory() {

    }

    /**
     * gets the instance
     * @return the instance
     */
    public static DAOFactory getDAOFactory() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    /**
     * creates a treatment DAO
     * @return return a new treatmentDAO
     */
    public TreatmentDAO createTreatmentDAO() {
        return new TreatmentDAO(ConnectionBuilder.getConnection());
    }

    /**
     * creates a patient DAO
     * @return return a new patientDAO
     */
    public PatientDAO createPatientDAO() {
        return new PatientDAO(ConnectionBuilder.getConnection());
    }

    /**
     * creates a caregiver DAO
     * @return return a new caregiverDAO
     */
    public CaregiverDAO createCaregiverDAO() {
        return new CaregiverDAO(ConnectionBuilder.getConnection());
    }
}
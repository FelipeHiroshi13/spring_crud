package med.voll.api.domain.doctor;

import med.voll.api.domain.adress.Adress;

public record DataDetailsDoctor(Long id, String name, String email, String crm, String phone, Speciality speciality,
                                Adress adress) {


    public DataDetailsDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(),
                doctor.getSpeciality(), doctor.getAdress());
    }

}

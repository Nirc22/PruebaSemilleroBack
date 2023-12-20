package com.semillero.pruebaSemillero.dao;


import com.semillero.pruebaSemillero.models.RafPacientesModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class RafPacienteDAOImpl implements RafPacienteDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RafPacientesModel> getPacientes() {
        String query = "FROM RafPacientesModel";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarPacientes(Long id) {
        RafPacientesModel rafPacientesModel = entityManager.find(RafPacientesModel.class, id);
        entityManager.remove(rafPacientesModel);
    }

    @Override
    public void registrarPaciente(RafPacientesModel rafPacientesModel) {
        entityManager.merge(rafPacientesModel);
    }


    @Override
    public void actualizarPacientes(Long id, RafPacientesModel rafPacientesModel) {
        RafPacientesModel updatePaciente = entityManager.find(RafPacientesModel.class, id);
        updatePaciente.setNmidpersona(rafPacientesModel.getNmidpersona());
        entityManager.merge(updatePaciente);
    }

    @Override
    public Optional<RafPacientesModel> getPacientesId(Long id) {
        RafPacientesModel rafPacientesModel = entityManager.find(RafPacientesModel.class, id);
        return Optional.of(rafPacientesModel);
    }

    @Override
    public ByteArrayInputStream exportPacientes() throws Exception{
        String [] columns = {"Id", "Nombre", "Especie", "Raza", "Fecha nacimiento", "Fecha registro", "Id Persona", "Tipo Identificación", "Número identificación", "Nombre", "Apellido","Ciudad","Dirección", "Teléfono"};
        Workbook workbook = new HSSFWorkbook();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Sheet sheet = workbook.createSheet("Pacientes");
        Row row = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columns[i]);
            
        }
        List<RafPacientesModel> rafPacientesModels = this.getPacientes();
        int initRow = 1;
        for (RafPacientesModel rafPacienteModels: rafPacientesModels) {
            row = sheet.createRow((initRow));
            row.createCell(0).setCellValue(rafPacienteModels.getNmid());
            row.createCell(1).setCellValue(rafPacienteModels.getDsnombre());
            row.createCell(2).setCellValue(rafPacienteModels.getNmidespecie().getDsnombre());
            row.createCell(3).setCellValue(rafPacienteModels.getNmidraza().getDsnombre());
            row.createCell(4).setCellValue(rafPacienteModels.getFenacimiento());
            row.createCell(5).setCellValue(rafPacienteModels.getFeregistro());
            row.createCell(6).setCellValue(rafPacienteModels.getNmidpersona().getNmidpersona());
            row.createCell(7).setCellValue(rafPacienteModels.getNmidpersona().getNmidtipoidentificacion().getDsnombre());
            row.createCell(8).setCellValue(rafPacienteModels.getNmidpersona().getNmidentificacion());
            row.createCell(9).setCellValue(rafPacienteModels.getNmidpersona().getDsnombre());
            row.createCell(10).setCellValue(rafPacienteModels.getNmidpersona().getDsapellido());
            row.createCell(11).setCellValue(rafPacienteModels.getNmidpersona().getDsciudad());
            row.createCell(12).setCellValue(rafPacienteModels.getNmidpersona().getDsdireccion());
            row.createCell(13).setCellValue(rafPacienteModels.getNmidpersona().getNmtelefono());


            initRow++;

            
        }
        workbook.write(stream);
        workbook.close();

        return new ByteArrayInputStream(stream.toByteArray());
    }


}

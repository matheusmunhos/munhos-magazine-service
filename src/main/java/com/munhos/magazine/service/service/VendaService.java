package com.munhos.magazine.service.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.munhos.magazine.service.domain.venda.Venda;
import com.munhos.magazine.service.domain.venda.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional
    public void gerarPDF() throws DocumentException, IOException {
        List<Venda> vendas = vendaRepository.findAll();

        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("vendas.pdf"));

        // Adiciona o título logo após a abertura do documento
        document.open();
        adicionarTitulo(document);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Venda venda : vendas) {
            document.add(new Paragraph("Venda: " + venda.getId()));
            document.add(new Paragraph("Produto: " + venda.getProduto().getNome()));
            document.add(new Paragraph("Cliente: " + venda.getCliente().getNome()));
            document.add(new Paragraph("Valor: " + venda.getValor()));
            document.add(new Paragraph("Data: " + venda.getData().format(dateFormatter))); // Formata a data
            document.add(new Paragraph("\n")); // Adiciona uma linha em branco entre as vendas
        }

        document.close();
    }

    private void adicionarTitulo(Document document) throws DocumentException {
        Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Paragraph title = new Paragraph("Munhós Móveis", font);
        Paragraph subject = new Paragraph("Extrato de vendas", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        subject.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(10);
        subject.setSpacingAfter(12);

        document.add(subject);
        document.add(title);
    }
}

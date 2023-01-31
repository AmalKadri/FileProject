package com.FileUpload.FileUpload.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documents")

public class Document {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name  ="uuid2",strategy ="uuid2")
    @Column(name = "id" )
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    private byte[] data;


}

package com.yijiaersan.webapp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Concept implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3008349272857213469L;

	private Long conceptId;

    private String conceptCode;

    private String conceptName;

    private BigDecimal conceptChangeRote;

    public Long getConceptId() {
        return conceptId;
    }

    public void setConceptId(Long conceptId) {
        this.conceptId = conceptId;
    }

    public String getConceptCode() {
        return conceptCode;
    }

    public void setConceptCode(String conceptCode) {
        this.conceptCode = conceptCode == null ? null : conceptCode.trim();
    }

    public String getConceptName() {
        return conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName == null ? null : conceptName.trim();
    }

    public BigDecimal getConceptChangeRote() {
        return conceptChangeRote;
    }

    public void setConceptChangeRote(BigDecimal conceptChangeRote) {
        this.conceptChangeRote = conceptChangeRote;
    }
}
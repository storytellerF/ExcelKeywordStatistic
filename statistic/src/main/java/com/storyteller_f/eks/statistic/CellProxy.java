package com.storyteller_f.eks.statistic;

import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class CellProxy implements Cell {
    org.odftoolkit.simple.table.Cell cell;

    public CellProxy(org.odftoolkit.simple.table.Cell cellByIndex) {
        this.cell=cellByIndex;
    }

    @Override
    public int getColumnIndex() {
        return 0;
    }

    @Override
    public int getRowIndex() {
        return 0;
    }

    @Override
    public Sheet getSheet() {
        return null;
    }

    @Override
    public Row getRow() {
        return null;
    }

    @Override
    public void setCellType(CellType cellType) {

    }

    @Override
    public void setBlank() {

    }

    @Override
    public CellType getCellType() {
        String valueType = cell.getValueType();
        if (valueType==null) return CellType._NONE;
        if (valueType.equals("string"))
            return CellType.STRING;
        return CellType._NONE;
    }

    @Override
    public CellType getCellTypeEnum() {
        return null;
    }

    @Override
    public CellType getCachedFormulaResultType() {
        return null;
    }

    @Override
    public CellType getCachedFormulaResultTypeEnum() {
        return null;
    }

    @Override
    public void setCellValue(double value) {

    }

    @Override
    public void setCellValue(Date value) {

    }

    @Override
    public void setCellValue(LocalDateTime value) {

    }

    @Override
    public void setCellValue(Calendar value) {

    }

    @Override
    public void setCellValue(RichTextString value) {

    }

    @Override
    public void setCellValue(String value) {

    }

    @Override
    public void setCellFormula(String formula) throws FormulaParseException, IllegalStateException {

    }

    @Override
    public void removeFormula() throws IllegalStateException {

    }

    @Override
    public String getCellFormula() {
        return null;
    }

    @Override
    public double getNumericCellValue() {
        return 0;
    }

    @Override
    public Date getDateCellValue() {
        return null;
    }

    @Override
    public LocalDateTime getLocalDateTimeCellValue() {
        return null;
    }

    @Override
    public RichTextString getRichStringCellValue() {
        return null;
    }

    @Override
    public String getStringCellValue() {
        return cell.getStringValue();
    }

    @Override
    public void setCellValue(boolean value) {

    }

    @Override
    public void setCellErrorValue(byte value) {

    }

    @Override
    public boolean getBooleanCellValue() {
        return false;
    }

    @Override
    public byte getErrorCellValue() {
        return 0;
    }

    @Override
    public void setCellStyle(CellStyle style) {

    }

    @Override
    public CellStyle getCellStyle() {
        return null;
    }

    @Override
    public void setAsActiveCell() {

    }

    @Override
    public CellAddress getAddress() {
        return null;
    }

    @Override
    public void setCellComment(Comment comment) {

    }

    @Override
    public Comment getCellComment() {
        return null;
    }

    @Override
    public void removeCellComment() {

    }

    @Override
    public Hyperlink getHyperlink() {
        return null;
    }

    @Override
    public void setHyperlink(Hyperlink link) {

    }

    @Override
    public void removeHyperlink() {

    }

    @Override
    public CellRangeAddress getArrayFormulaRange() {
        return null;
    }

    @Override
    public boolean isPartOfArrayFormulaGroup() {
        return false;
    }
}

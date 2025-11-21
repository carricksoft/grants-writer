/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:24. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name="document_text")
@Table(name="`document_text`")
public class DocumentText extends BaseText {

}

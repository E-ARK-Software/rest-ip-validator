Validation Scope
================
Below is a brief assessment of the commons-ip package's valiation capabilities. The commons-ip package is primarily aimed at developers wanting to work

## Initial Extract
- Checks if zipped or a directory
- If zipped:
  - checks for `METS.xml` file in destination directory
  - if no `METS.xml` found then searches directories for `METS.xml` and notes the path

## METS Processing
### Initial extraction
- Parse METS documents using embedded METS 1.11 schema
- Extracts:
  - object ids;
  - creation date;
  - last modified date;
  - recored status; and
  - agents.

### Struct Map Processing
- look for main/representation struct map labelled either:
  - "Common Specification structural map"; or
  - "E-ARK structural map"
- extracts metadata:
  - descriptive;
  - preservation; and
  - other
- extracts divs for:
  - representations
  - data
  - schemas
  - documentation
  - submission

At this stage the SIP is considered valid
### Validation Issues
- no `METS.xml` found, either in root dir or search (if zip only??)
- `METS.xml` not parsable as XML
- `METS.xml` doesn't comply with METS 1.11 schema
- no METS `TYPE` attribute value
- invalid METS `TYPE` attribute value
- `TYPE` attribute doesn't match package type, i.e. not `SIP` for SIP package (not sure how the package type is pre-declared yet, the code currently seems to assume SIP although a test for AIPs exists)
- Main METS document has no EARK struct map
- Representation has no EARK struct map
- metadata file pointer not found
- metadata file not found

### Validation warnings
- unknown descriptive metadata type (set to standard type)

### Validation information
- found metadata with matching checksum

### Application errors
- thread interupted
- I/O issues
- Java calendar issues

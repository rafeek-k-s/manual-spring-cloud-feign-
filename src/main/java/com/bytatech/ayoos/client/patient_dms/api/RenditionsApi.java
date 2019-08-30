/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.ayoos.client.patient_dms.api;

import com.bytatech.ayoos.client.patient_dms.model.Error;
import java.time.OffsetDateTime;
import com.bytatech.ayoos.client.patient_dms.model.RenditionBodyCreate;
import com.bytatech.ayoos.client.patient_dms.model.RenditionEntry;
import com.bytatech.ayoos.client.patient_dms.model.RenditionPaging;
import org.springframework.core.io.Resource;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-10T09:58:46.053+05:30[Asia/Kolkata]")

@Api(value = "Renditions", description = "the Renditions API")
public interface RenditionsApi {

    @ApiOperation(value = "Create rendition", nickname = "createRendition", notes = "**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  An asynchronous request to create a rendition for file **nodeId**.  The rendition is specified by name **id** in the request body: ```JSON {   \"id\":\"doclib\" } ```  Multiple names may be specified as a comma separated list or using a list format: ```JSON [   {      \"id\": \"doclib\"   },   {      \"id\": \"avatar\"   } ] ``` ", tags={ "renditions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Request accepted"),
        @ApiResponse(code = 400, message = "Invalid parameter: **nodeId** is not a valid format or is not a file or **renditionBodyCreate** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "Current user does not have permission for **nodeId**"),
        @ApiResponse(code = 404, message = "**nodeId** or **renditionId** does not exist "),
        @ApiResponse(code = 409, message = "All requested renditions already exist"),
        @ApiResponse(code = 501, message = "Renditions/thumbnails are disabled for the system"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/renditions",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<Void> createRendition(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@ApiParam(value = "The rendition id" ,required=true )  @Valid @RequestBody RenditionBodyCreate renditionBodyCreate);


    @ApiOperation(value = "Get rendition information", nickname = "getRendition", notes = "**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  Gets the rendition information for **renditionId** of file **nodeId**. ", response = RenditionEntry.class, tags={ "renditions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = RenditionEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **nodeId** is not a valid format, or is not a file, or **renditionId** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "Current user does not have permission for **nodeId**"),
        @ApiResponse(code = 404, message = "**nodeId** or **renditionId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/renditions/{renditionId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<RenditionEntry> getRendition(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@ApiParam(value = "The name of a thumbnail rendition, for example *doclib*, or *pdf*.",required=true) @PathVariable("renditionId") String renditionId);


    @ApiOperation(value = "Get rendition content", nickname = "getRenditionContent", notes = "**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  Gets the rendition content for **renditionId** of file **nodeId**. ", response = Resource.class, tags={ "renditions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Resource.class),
        @ApiResponse(code = 206, message = "Partial Content"),
        @ApiResponse(code = 304, message = "Content has not been modified since the date provided in the If-Modified-Since header"),
        @ApiResponse(code = 400, message = "Invalid parameter: **nodeId** is not a valid format, or is not a file, or **renditionId** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "Current user does not have permission for **nodeId**"),
        @ApiResponse(code = 404, message = "**nodeId** or **renditionId** does not exist "),
        @ApiResponse(code = 416, message = "Range Not Satisfiable"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/renditions/{renditionId}/content",
        produces = "application/octet-stream", 
        method = RequestMethod.GET)
    ResponseEntity<Resource> getRenditionContent(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@ApiParam(value = "The name of a thumbnail rendition, for example *doclib*, or *pdf*.",required=true) @PathVariable("renditionId") String renditionId,@ApiParam(value = "**true** enables a web browser to download the file as an attachment. **false** means a web browser may preview the file in a new tab or window, but not download the file.  You can only set this parameter to **false** if the content type of the file is in the supported list; for example, certain image files and PDF files.  If the content type is not supported for preview, then a value of **false**  is ignored, and the attachment will be returned in the response. ", defaultValue = "true") @Valid @RequestParam(value = "attachment", required = false, defaultValue="true") Boolean attachment,@ApiParam(value = "Only returns the content if it has been modified since the date provided. Use the date format defined by HTTP. For example, `Wed, 09 Mar 2016 16:56:34 GMT`. " ) @RequestHeader(value="If-Modified-Since", required=false) OffsetDateTime ifModifiedSince,@ApiParam(value = "The Range header indicates the part of a document that the server should return. Single part request supported, for example: bytes=1-10. " ) @RequestHeader(value="Range", required=false) String range,@ApiParam(value = "If **true** and there is no rendition for this **nodeId** and **renditionId**,  then the placeholder image for the mime type of this rendition is returned, rather  than a 404 response. ", defaultValue = "false") @Valid @RequestParam(value = "placeholder", required = false, defaultValue="false") Boolean placeholder);


    @ApiOperation(value = "List renditions", nickname = "listRenditions", notes = "**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  Gets a list of the rendition information for each rendition of the the file **nodeId**, including the rendition id.  Each rendition returned has a **status**: CREATED means it is available to view or download, NOT_CREATED means the rendition can be requested.  You can use the **where** parameter to filter the returned renditions by **status**. For example, the following **where**  clause will return just the CREATED renditions:    ``` (status='CREATED') ``` ", response = RenditionPaging.class, tags={ "renditions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = RenditionPaging.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **nodeId** is not a valid format, is not a file, or **where** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "Current user does not have permission for **nodeId**"),
        @ApiResponse(code = 404, message = "**nodeId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/renditions",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<RenditionPaging> listRenditions(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@ApiParam(value = "A string to restrict the returned objects by using a predicate.") @Valid @RequestParam(value = "where", required = false) String where);

}

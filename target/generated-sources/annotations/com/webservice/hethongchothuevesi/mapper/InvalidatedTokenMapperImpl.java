package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.InvalidatedTokenDTO;
import com.webservice.hethongchothuevesi.entity.InvalidatedToken;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-12T19:01:13+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class InvalidatedTokenMapperImpl implements InvalidatedTokenMapper {

    @Override
    public InvalidatedTokenDTO toDTO(InvalidatedToken entity) {
        if ( entity == null ) {
            return null;
        }

        InvalidatedTokenDTO.InvalidatedTokenDTOBuilder invalidatedTokenDTO = InvalidatedTokenDTO.builder();

        invalidatedTokenDTO.id( entity.getId() );
        if ( entity.getExpiryTime() != null ) {
            invalidatedTokenDTO.expiryTime( LocalDateTime.ofInstant( entity.getExpiryTime().toInstant(), ZoneId.of( "UTC" ) ) );
        }

        return invalidatedTokenDTO.build();
    }

    @Override
    public InvalidatedToken toEntity(InvalidatedTokenDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InvalidatedToken.InvalidatedTokenBuilder invalidatedToken = InvalidatedToken.builder();

        invalidatedToken.id( dto.getId() );
        if ( dto.getExpiryTime() != null ) {
            invalidatedToken.expiryTime( Date.from( dto.getExpiryTime().toInstant( ZoneOffset.UTC ) ) );
        }

        return invalidatedToken.build();
    }

    @Override
    public List<InvalidatedTokenDTO> toListDto(List<InvalidatedToken> list) {
        if ( list == null ) {
            return null;
        }

        List<InvalidatedTokenDTO> list1 = new ArrayList<InvalidatedTokenDTO>( list.size() );
        for ( InvalidatedToken invalidatedToken : list ) {
            list1.add( toDTO( invalidatedToken ) );
        }

        return list1;
    }

    @Override
    public void updateEntity(InvalidatedToken entity, InvalidatedTokenDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getExpiryTime() != null ) {
            entity.setExpiryTime( Date.from( dto.getExpiryTime().toInstant( ZoneOffset.UTC ) ) );
        }
    }
}

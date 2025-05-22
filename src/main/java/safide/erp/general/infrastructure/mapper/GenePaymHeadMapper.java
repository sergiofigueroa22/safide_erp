package safide.erp.general.infrastructure.mapper;

import org.mapstruct.Mapper;
import safide.erp.general.domain.model.GenePaymHead;
import safide.erp.general.infrastructure.entity.GenePaymHeadEntity;
import safide.erp.generic.infrastructure.mapper.GeneErpMapper;

@Mapper(componentModel = "spring", uses = {GenePaymDetaMapper.class})
public interface GenePaymHeadMapper extends GeneErpMapper<GenePaymHead, GenePaymHeadEntity> {
}

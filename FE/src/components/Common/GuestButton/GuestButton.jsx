import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import styled, { css } from "styled-components";
import SearchNaviButton from "Components/Common/SearchNaviButton/SearchNaviButton";

import adultCountAction from "Actions/guest/adultCountAction";
import childrenCountAction from "Actions/guest/childrenCountAction";
import infantsCountAction from "Actions/guest/infantsCountAction";

const TYPE_ADULT = "TYPE_ADULT";
const TYPE_CHILDREN = "TYPE_CHILDREN";
const TYPE_INFANTS = "TYPE_INFANTS";

const S = {};
S.GuestButton = styled.div`
  width: 250px;
  height: 70px;
`;

S.GuestArea = styled.div`
  position: absolute;
  top: 72px;
  right: 130px;
  width: 354px;
  height: 220px;
  padding: 16px 24px;
  display: ${(props) => (props.focus ? "block" : "none")};
  background-color: white;
  border-bottom-left-radius: 12px;
  border-bottom-right-radius: 12px;
  box-shadow: rgba(0, 0, 0, 0.12) 0px 5px 12px;
  border-color: rgb(247, 247, 247);
`;

S.Guest = styled.div`
  position: relative;
  width: 337px;
  height: 38px;
  padding: 16px 0px 16px 0px;
`;

S.GuestDescription = styled.div`
  float: left;
  width: 240px;
  font-size: 16px;
  font-weight: bold;
  line-height: 20px;
`;

S.GuestType = styled.div`
  width: 240px;
  font-size: 16px;
  font-weight: bold;
  line-height: 20px;
`;

S.GuestTypeDescription = styled.p`
  position: relative;
  width: 240px;
  font-size: 14px;
  line-height: 18px;
  color: #717171;
`;

S.GuestController = styled.div`
  position: relative;
  height: 32px;
  vertical-align: center;
`;

S.Count = styled.div`
  position: relative;
  float: left;
  width: 20px;
  padding-left: 5px;
  padding-right: 5px;
  line-height: 32px;
  font-size: 16px;
  user-select: none;
  text-align: center;
`;

S.MinusButton = styled.div`
  width: 32px;
  height: 32px;
  float: left;
  background-image: url("http://dev-angelo.dlinkddns.com/minus_normal.png");
  background-size: 100% 100%;

  &:hover {
    background-image: url("http://dev-angelo.dlinkddns.com/minus_hover.png");
    cursor: pointer;
  }

  ${(props) =>
    props.disabled &&
    css`
      background-image: url("http://dev-angelo.dlinkddns.com/minus_disabled.png");
      pointer-events: none;
  `};
`;

S.PlusButton = styled.div`
  width: 32px;
  height: 32px;
  float: left;
  background-image: url("http://dev-angelo.dlinkddns.com/plus_normal.png");
  background-size: 100% 100%;

  &:hover {
    background-image: url("http://dev-angelo.dlinkddns.com/plus_hover.png");
    cursor: pointer;
  }

  ${(props) =>
    props.disabled &&
    css`
      background-image: url("http://dev-angelo.dlinkddns.com/plus_disabled.png");
      pointer-events: none;
  `};
`;

function GuestButton(props) {
  const { adultCount, childrenCount, infantsCount } = useSelector(
    ({ guestCountReducer }) => guestCountReducer
  );

  const dispatch = useDispatch();

  function onDropDownAreaClick(e) {
    e.stopPropagation();
  }

  function onPlusButtonClick(type) {
    let increaseFunc = null;

    const increaseFuncMap = {
      TYPE_ADULT: adultCountAction.increase,
      TYPE_CHILDREN: childrenCountAction.increase,
      TYPE_INFANTS: infantsCountAction.increase
    }

    dispatch(increaseFuncMap[type]());
  }

  function onMinusButtonClick(type) {
    let decreaseFunc = null;

    const decreaseFuncMap = {
      TYPE_ADULT: adultCountAction.decrease,
      TYPE_CHILDREN: childrenCountAction.decrease,
      TYPE_INFANTS: infantsCountAction.decrease
    }

    dispatch((decreaseFuncMap[type])());
  }

  return (
    <S.GuestButton onClick={onDropDownAreaClick}>
      <SearchNaviButton
        title={props.title}
        contents={(adultCount + childrenCount + infantsCount) > 0 ? 
          ((adultCount + childrenCount > 0) ? "게스트 " + (adultCount + childrenCount) + "명" : "") +
          ((infantsCount > 0) ? ((adultCount + childrenCount > 0) ? ', ' : "") + "유아 " + (infantsCount) + "명" : "")
          : props.contents}
        onClick={props.onClick}
        focus={props.focus}
      />
      <S.GuestArea focus={props.focus}>
        <S.Guest>
          <S.GuestDescription>
            <S.GuestType>성인</S.GuestType>
            <S.GuestTypeDescription>만 13세 이상</S.GuestTypeDescription>
          </S.GuestDescription>
          <S.GuestController>
            <S.MinusButton onClick={() => onMinusButtonClick(TYPE_ADULT)} disabled={adultCount == 0} />
            <S.Count>{adultCount}</S.Count>
            <S.PlusButton onClick={() => onPlusButtonClick(TYPE_ADULT)} disabled={adultCount == 16} />
          </S.GuestController>
        </S.Guest>
        <S.Guest>
          <S.GuestDescription>
            <S.GuestType>어린이</S.GuestType>
            <S.GuestTypeDescription>2~12세</S.GuestTypeDescription>
          </S.GuestDescription>
          <S.GuestController>
            <S.MinusButton onClick={() => onMinusButtonClick(TYPE_CHILDREN)} disabled={childrenCount == 0} />
            <S.Count>{childrenCount}</S.Count>
            <S.PlusButton onClick={() => onPlusButtonClick(TYPE_CHILDREN)} disabled={childrenCount == 5} />
          </S.GuestController>
        </S.Guest>
        <S.Guest>
          <S.GuestDescription>
            <S.GuestType>유아</S.GuestType>
            <S.GuestTypeDescription>2세 미만</S.GuestTypeDescription>
          </S.GuestDescription>
          <S.GuestController>
            <S.MinusButton onClick={() => onMinusButtonClick(TYPE_INFANTS)} disabled={infantsCount == 0} />
            <S.Count>{infantsCount}</S.Count>
            <S.PlusButton onClick={() => onPlusButtonClick(TYPE_INFANTS)} disabled={infantsCount == 5} />
          </S.GuestController>
        </S.Guest>
      </S.GuestArea>
    </S.GuestButton>
  );
}

export default GuestButton;
